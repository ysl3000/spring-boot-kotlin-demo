/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.persistence.EntityManager
import javax.persistence.criteria.Predicate

@Component
class CodeListRepository {

	@Autowired
	lateinit var entityManager: EntityManager

	fun findCodeListLikeCB(predicateMap: Map<String, Any?>): List<CodeList> {

		val cb = entityManager.criteriaBuilder

		val query = cb.createQuery(CodeList::class.java)

		val codeListRoot = query.from(CodeList::class.java)

		val predicateList: ArrayList<Predicate> = ArrayList()

		// foreach to build predicateList
		for ((key, value) in predicateMap) {
			if (value != null) {
				// For a list, needed to add a condition IN
				if (value is List<*>)
					predicateList.add(codeListRoot.get<Any>(key).`in`(value))

				//For a date, needed to add condition
				//  For start date --> before param start date
				//  For end date   --> after param date or null
				if (value is LocalDate) {
					if (key == "startEffectDate") {
						predicateList.add(cb.lessThanOrEqualTo(codeListRoot.get("startEffectDate"), value))
					}
					if (key == "endEffectDate") {
						// cb.conjunction allow to add parenthesis to the predicate
						val predicate = cb.conjunction()
						predicate.expressions.add(cb.or(cb.greaterThan(codeListRoot.get("endEffectDate"), value), cb.isNull(codeListRoot.get<Any>("endEffectDate"))))
						predicateList.add(predicate)
					}
				}
				if (value !is LocalDate && value !is List<*>) {
					predicateList.add(cb.equal(codeListRoot.get<Any>(key), value))
				}
			}
		}

		query.select(codeListRoot).where(cb.and(*predicateList.toTypedArray()))

		return entityManager.createQuery(query).resultList
	}

}

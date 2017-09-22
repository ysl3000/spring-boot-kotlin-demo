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

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "code_list")
class CodeList : Serializable {

	@Id
	@Column(name = "NO_SECSOC", nullable = false)
	var secSocId: Long? = null
	@Id
	@Column(name = "ID_CODE_LIST")
	var codelistId: String? = null
	@Id
	@Column(name = "NO_COM_PARITAIRE")
	var comParitaireId: String? = null
	@Id
	@Column(name = "NO_EMPLOYEUR")
	var employerId: Long? = null
	@Id
	@Column(name = "NO_CCTE")
	var ccteId: String? = null
	@Id
	@Column(name = "VAL_NUM")
	var numberValue: Long? = null
	@Id
	@Column(name = "VAL_STRING")
	var stringValue: String? = null

	@Column(name = "DT_DEBUT_EFFET")
	var startEffectDate: LocalDate? = null

	@Column(name = "DT_FIN_EFFET")
	var endEffectDate: LocalDate? = null

	@Embedded
	var label: String? = null

	constructor() {}

	constructor(secSocId: Long?, employerId: Long?, ccteId: String, codeListId: String) {
		this.secSocId = secSocId
		this.employerId = employerId
		this.ccteId = ccteId
		this.codelistId = codeListId
	}

}

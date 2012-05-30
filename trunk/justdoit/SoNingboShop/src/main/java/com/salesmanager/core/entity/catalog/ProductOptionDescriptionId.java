/*
 * Licensed to csti consulting 
 * You may obtain a copy of the License at
 *
 * http://www.csticonsulting.com
 * Copyright (c) 2006-Aug 24, 2010 Consultation CS-TI inc. 
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.salesmanager.core.entity.catalog;

// Generated Sep 17, 2008 4:47:02 PM by Hibernate Tools 3.2.0.beta8

/**
 * ProductsOptionsDescriptionId generated by hbm2java
 */
public class ProductOptionDescriptionId implements java.io.Serializable {

	// Fields

	private long productOptionId;

	private int languageId;

	// Constructors

	/** default constructor */
	public ProductOptionDescriptionId() {
	}

	/** full constructor */
	public ProductOptionDescriptionId(long productOptionId, int languageId) {
		this.productOptionId = productOptionId;
		this.languageId = languageId;
	}

	// Property accessors
	public long getProductOptionId() {
		return this.productOptionId;
	}

	public void setProductOptionId(long productOptionId) {
		this.productOptionId = productOptionId;
	}

	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

}
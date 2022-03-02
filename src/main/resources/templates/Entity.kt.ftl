package ${selectedPackage};

import com.moti.shop.model.entity.sf.base.NormalSalesForceEntity
import com.moti.shop.model.entity.sf.base.SalesforceEntity
import com.moti.shop.model.entity.sf.base.SalesforceProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column

@Schema(description = "${entityModel.entityRemark}")
@SalesforceEntity("${entityModel.objectName}")
@Entity
@Table(name = "${entityModel.tableName}")
class ${entityModel.entityName} : NormalSalesForceEntity() {
<#list propertyModels as property>

    @Schema(description = "${property.label}")
    @SalesforceProperty("${property.name}")
    <#if property.length gt 0 || property.scale gt 0>
    @Column(length = ${property.length}, scale = ${property.scale} )
    </#if>
    var ${property.mappingName}: ${property.mappingType}? = null
</#list>

    companion object {
        const val SOQL = "${entityModel.soql}"
    }

}
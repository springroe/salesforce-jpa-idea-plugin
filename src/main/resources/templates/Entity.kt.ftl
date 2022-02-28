package ${selectedPackage};

import com.moti.shop.model.entity.sf.base.NormalSalesForceEntity
import com.moti.shop.model.entity.sf.base.SalesforceEntity
import com.moti.shop.model.entity.sf.base.SalesforceProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@ApiModel("${classDescription}")
@SalesforceEntity("${classObjectName}")
@Entity
@Table(name = "${tableName}")
class ${className} : NormalSalesForceEntity() {
<#list propertyList as property>

    @ApiModelProperty("${property.label}")
    @SalesforceProperty("${property.name}")
    var ${property.getJavaName()}: ${property.getJavaType()}? = null
</#list>
}

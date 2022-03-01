/*
 * salesforce api
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.openapitools.client.model.ObjectMetaDataUrls;

/**
 * ObjectMetaDataRecordTypeInfos
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-01T18:23:34.688259300+08:00[Asia/Shanghai]")
public class ObjectMetaDataRecordTypeInfos {
  public static final String SERIALIZED_NAME_ACTIVE = "active";
  @SerializedName(SERIALIZED_NAME_ACTIVE)
  private Boolean active;

  public static final String SERIALIZED_NAME_AVAILABLE = "available";
  @SerializedName(SERIALIZED_NAME_AVAILABLE)
  private Boolean available;

  public static final String SERIALIZED_NAME_DEFAULT_RECORD_TYPE_MAPPING = "defaultRecordTypeMapping";
  @SerializedName(SERIALIZED_NAME_DEFAULT_RECORD_TYPE_MAPPING)
  private Boolean defaultRecordTypeMapping;

  public static final String SERIALIZED_NAME_DEVELOPER_NAME = "developerName";
  @SerializedName(SERIALIZED_NAME_DEVELOPER_NAME)
  private String developerName;

  public static final String SERIALIZED_NAME_MASTER = "master";
  @SerializedName(SERIALIZED_NAME_MASTER)
  private Boolean master;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_RECORD_TYPE_ID = "recordTypeId";
  @SerializedName(SERIALIZED_NAME_RECORD_TYPE_ID)
  private String recordTypeId;

  public static final String SERIALIZED_NAME_URLS = "urls";
  @SerializedName(SERIALIZED_NAME_URLS)
  private ObjectMetaDataUrls urls;


  public ObjectMetaDataRecordTypeInfos active(Boolean active) {
    
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getActive() {
    return active;
  }


  public void setActive(Boolean active) {
    this.active = active;
  }


  public ObjectMetaDataRecordTypeInfos available(Boolean available) {
    
    this.available = available;
    return this;
  }

   /**
   * Get available
   * @return available
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAvailable() {
    return available;
  }


  public void setAvailable(Boolean available) {
    this.available = available;
  }


  public ObjectMetaDataRecordTypeInfos defaultRecordTypeMapping(Boolean defaultRecordTypeMapping) {
    
    this.defaultRecordTypeMapping = defaultRecordTypeMapping;
    return this;
  }

   /**
   * Get defaultRecordTypeMapping
   * @return defaultRecordTypeMapping
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDefaultRecordTypeMapping() {
    return defaultRecordTypeMapping;
  }


  public void setDefaultRecordTypeMapping(Boolean defaultRecordTypeMapping) {
    this.defaultRecordTypeMapping = defaultRecordTypeMapping;
  }


  public ObjectMetaDataRecordTypeInfos developerName(String developerName) {
    
    this.developerName = developerName;
    return this;
  }

   /**
   * Get developerName
   * @return developerName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDeveloperName() {
    return developerName;
  }


  public void setDeveloperName(String developerName) {
    this.developerName = developerName;
  }


  public ObjectMetaDataRecordTypeInfos master(Boolean master) {
    
    this.master = master;
    return this;
  }

   /**
   * Get master
   * @return master
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getMaster() {
    return master;
  }


  public void setMaster(Boolean master) {
    this.master = master;
  }


  public ObjectMetaDataRecordTypeInfos name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ObjectMetaDataRecordTypeInfos recordTypeId(String recordTypeId) {
    
    this.recordTypeId = recordTypeId;
    return this;
  }

   /**
   * Get recordTypeId
   * @return recordTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRecordTypeId() {
    return recordTypeId;
  }


  public void setRecordTypeId(String recordTypeId) {
    this.recordTypeId = recordTypeId;
  }


  public ObjectMetaDataRecordTypeInfos urls(ObjectMetaDataUrls urls) {
    
    this.urls = urls;
    return this;
  }

   /**
   * Get urls
   * @return urls
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ObjectMetaDataUrls getUrls() {
    return urls;
  }


  public void setUrls(ObjectMetaDataUrls urls) {
    this.urls = urls;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectMetaDataRecordTypeInfos objectMetaDataRecordTypeInfos = (ObjectMetaDataRecordTypeInfos) o;
    return Objects.equals(this.active, objectMetaDataRecordTypeInfos.active) &&
        Objects.equals(this.available, objectMetaDataRecordTypeInfos.available) &&
        Objects.equals(this.defaultRecordTypeMapping, objectMetaDataRecordTypeInfos.defaultRecordTypeMapping) &&
        Objects.equals(this.developerName, objectMetaDataRecordTypeInfos.developerName) &&
        Objects.equals(this.master, objectMetaDataRecordTypeInfos.master) &&
        Objects.equals(this.name, objectMetaDataRecordTypeInfos.name) &&
        Objects.equals(this.recordTypeId, objectMetaDataRecordTypeInfos.recordTypeId) &&
        Objects.equals(this.urls, objectMetaDataRecordTypeInfos.urls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, available, defaultRecordTypeMapping, developerName, master, name, recordTypeId, urls);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectMetaDataRecordTypeInfos {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    defaultRecordTypeMapping: ").append(toIndentedString(defaultRecordTypeMapping)).append("\n");
    sb.append("    developerName: ").append(toIndentedString(developerName)).append("\n");
    sb.append("    master: ").append(toIndentedString(master)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    recordTypeId: ").append(toIndentedString(recordTypeId)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

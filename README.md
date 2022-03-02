# salesforce-jpa-idea-plugin
插件主要作用是通过salesforce rest api 或 salesforce对象管理器中的属性描述文本自动生成jpa entity class等

使用说明：
1.salesforce setting(Optional)
如果需要使用 New Entity Use Api 则该项必填！！！！！
  ![img.png](images/img.png)

2.New Entity Use Api(Optional)
·在需要生成class的package上使用右键菜单  
![img.png](images/img1.png)
  
·填写生成参数  
*（注1：Properties是可以选择的，必须选择需要生成的属性，ctrl+a全选）*  
*（注2：Properties中的单元格可以进行修改）*  
![img.png](images/img2.png)

3.New Entity Use Api(Optional)
·在需要生成class的package上使用右键菜单    
  
![img.png](images/img3.png)
![img.png](images/img5.png)
·从salesforce对象管理器复制文本 **贴入Data Text**


![img.png](images/img4.png)  
格式如下：  
*上xx码	AccouxxodePen__c	公式 (文本)		假
*信xx整标记	Infxxompleted__c	复选框		假
*xx)	Countxxak__c	查找(区(县))		真
*意向xx折扣百分比	Intentxxcount__c	百分比(10, 8)

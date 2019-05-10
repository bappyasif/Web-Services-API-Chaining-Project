<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Request Returns Country's Currency</description>
   <name>New SOAP Request For Country Currency</name>
   <tag></tag>
   <elementGuidId>470dfb3d-3c81-44b6-8850-90bd055429c2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;Envelope xmlns=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot;>
    &lt;Body>
        &lt;CurrencyName xmlns=&quot;http://www.oorsprong.org/websamples.countryinfo&quot;>
            &lt;sCurrencyISOCode>${countryCurrencyISOCode}&lt;/sCurrencyISOCode>
        &lt;/CurrencyName>
    &lt;/Body>
&lt;/Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>CountryCurrency</soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.currencyCode</defaultValue>
      <description></description>
      <id>2e459380-ec29-4e13-8700-d69537e60721</id>
      <masked>false</masked>
      <name>countryCurrencyISOCode</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyElementText(response, 'CurrencyNameResponse.CurrencyNameResult', 'Taka')</verificationScript>
   <wsdlAddress>http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL</wsdlAddress>
</WebServiceRequestEntity>

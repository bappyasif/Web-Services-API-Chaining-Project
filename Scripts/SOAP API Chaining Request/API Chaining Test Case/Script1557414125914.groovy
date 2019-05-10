import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

countryName = WS.sendRequest(findTestObject('SOAP API Service Request/New SOAP API Request For Country Name'))

//WS.verifyElementText(countryName, 'ListOfCountryNamesByNameResponse.ListOfCountryNamesByNameResult.tCountryCodeAndName[22]', 'BD')
String xmlResponse = countryName.responseBodyContent

def extractedValue = new XmlSlurper().parseText(xmlResponse)

def countryISO = extractedValue.ListOfCountryNamesByNameResult.tCountryCodeAndName[18].sISOCode.text()

println('Extracted Country Code IS : ' + countryISO)

GlobalVariable.countryCode = countryISO

println('Global Variable Current Value : ' + GlobalVariable.countryCode // this change was required before calling out next API to get Country Capital.
    )

WS.sendRequestAndVerify(findTestObject('SOAP API Service Request/New SOAP API Request For Country Capital'))


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

currencyName = WS.sendRequest(findTestObject('SOAP API Service Request/New SOAP API Request For Curency Info'))

//WS.verifyElementText(response, 'ListOfCurrenciesByCodeResponse.ListOfCurrenciesByCodeResult.tCurrency[18].sISOCode', 'BHD')
String xmlResponse = currencyName.responseBodyContent

def dataValue = new XmlSlurper().parseText(xmlResponse)

def valueExtracted = dataValue.ListOfCurrenciesByCodeResult.tCurrency[13].sISOCode.text()

println('Extracted Value : ' + valueExtracted)

GlobalVariable.currencyCode = valueExtracted // This value will be used for Our Next API Send Request.

println('Curren Global Variable Value  : ' + GlobalVariable.currencyCode)

WS.sendRequestAndVerify(findTestObject('SOAP API Service Request/New SOAP Request For Country Currency'))


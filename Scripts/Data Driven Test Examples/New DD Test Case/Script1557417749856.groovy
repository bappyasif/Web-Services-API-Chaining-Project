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

println ("Country Name : " +CountryCode)

println ("Capital Name : " +CapitalCity)

println ("Currency Name : " +CurrencyName)

capitalResponse = WS.sendRequest(findTestObject('API Data Driven Sample/New SOAP API Request For Country Capital', [('isoCodeForCountry') : CountryCode]))

WS.verifyElementText(capitalResponse, 'CapitalCityResponse.CapitalCityResult', CapitalCity)

//println ("Capital Name : " +capitalResponse)

currencyResponse = WS.sendRequest(findTestObject('API Data Driven Sample/New SOAP Request For Country Currency', [('countryCode') : CountryCode]))

//println ("Currency Name : " +currencyResponse)

WS.verifyElementText(currencyResponse, 'CountryCurrencyResponse.CountryCurrencyResult.sName', CurrencyName)

//println ("Currency Name : " +currencyResponse)
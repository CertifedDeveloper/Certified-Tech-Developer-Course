const {Builder, Key, By, Capabilities} = require("selenium-webdriver")
const chromeCapabilities = Capabilities.chrome()
const assert = require("assert")

async function TC_001(){
    chromeCapabilities.set('chromeOptions', {args:['--headless']})
    let driver = await new Builder().forBrowser('chrome').withCapabilities(chromeCapabilities).build()
    
    await driver.get('https://playground.digitalhouse.com')
    await driver.manage().window().maximize()

    await driver.sleep(10000)

    await driver.findElement(By.id('username')).sendKeys('arturohernandez8752@gmail.com')
    await driver.findElement(By.id('input-password')).sendKeys('arturohernandez8752@gmail.com')
    await driver.findElement(By.css("#SubmitLoginButton>.button__text")).click()

    await driver.sleep(2000)

    let buttonTextToCompare = await driver.findElement(By.xpath("//span[contains(.,'Arturo')]")).getText('value')
    assert.strictEqual(buttonTextToCompare, "Arturo")
    console.log("Login Successfully")

    await driver.sleep(1000)
    await driver.quit()
}
TC_001()
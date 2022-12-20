const {Builder, Key, By, Capabilities} = require("selenium-webdriver")
const chromeCapabilities = Capabilities.chrome()
const assert = require("assert")

async function TC_001(){
    chromeCapabilities.set('chromeOptions', {args:['--headless']})
    let driver = await new Builder().forBrowser('chrome').withCapabilities(chromeCapabilities).build()
    
    await driver.get('https://www.facebook.com')
    await driver.manage().window().maximize()

    await driver.sleep(10000)

    await driver.findElement(By.id('email')).sendKeys('correo@email.com')
    await driver.findElement(By.id('pass')).sendKeys('12345')
    await driver.findElement(By.xpath("//button[type= 'submit']")).click()

    await driver.sleep(2000)

    let buttonTextToCompare = await driver.findElement(By.id('checkpointSubmitButton')).getAttribute('value')
    assert.strictEqual(buttonTextToCompare, "Continuar")
    console.log("Login Successfully")

    await driver.sleep(1000)
    await driver.quit()
}
TC_001()
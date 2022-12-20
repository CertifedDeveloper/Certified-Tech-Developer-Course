const {Builder, Key, By, Capabilities} = require("selenium-webdriver")
const chromeCapabilities = Capabilities.chrome()
const assert = require("assert")

async function TC_001(){
    chromeCapabilities.set('chromeOptions', {args:['--headless']})
    let driver = await new Builder().forBrowser('chrome').withCapabilities(chromeCapabilities).build()
    
    await driver.get('https://www.youtube.com')
    await driver.manage().window().maximize()

    await driver.sleep(10000)

    await driver.findElement(By.css("#search-input > #search")).sendKeys('Digital House')
    await driver.findElement(By.css("#search-icon-legacy > .style-scope:nth-child(1)")).click()
    await driver.sleep(1000)
    await driver.findElement(By.css("#main-link")).click()

    await driver.sleep(2000)

    let buttonTextToCompare = await driver.findElement(By.css("#subscriber-count")).getText('value')
    assert.match(buttonTextToCompare, /suscriptores/)
    console.log("Se encontró la página de Digital House con suscriptores")

    await driver.sleep(1000)
    await driver.quit()
}
TC_001()
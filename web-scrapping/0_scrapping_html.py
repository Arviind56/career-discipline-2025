from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

url = "https://leetcode.com/u/arvindrajagopalan87/"

driver = webdriver.Chrome() 

try:
    driver.get(url)

    WebDriverWait(driver, 15).until(
        EC.presence_of_element_located((By.CLASS_NAME, "echarts-for-react"))
    )

    time.sleep(2) 

    page_content = driver.page_source

    with open("leetcode_profile_complete.html", "w", encoding="utf-8") as f:
        f.write(page_content)

    print("Successfully saved the fully loaded page!")

finally:
    driver.quit()
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

from web_driver_mng import WebDriverManager


class Web(object):
    _driver = None

    def __init__(self, browser):
        self._driver = WebDriverManager.get_web_driver(browser)
        self._wait = WebDriverWait(self._driver, 10)

    def get_web_element_by_css(self, css):
        return self._wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, css)))

    def get_web_elements_by_css(self, css):
        return self._wait.until(EC.visibility_of_all_elements_located((By.CSS_SELECTOR, css)))

    def open(self, path):
        self._driver.get(path)

    def close_all(self):
        self._driver.quit()
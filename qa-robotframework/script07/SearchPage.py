import sys
sys.path.insert(0, '../library/src/web_driver')

from web import Web

class SearchPage(object):

    __url = "http://google.com"

    def open_browser(self):
        self._web.open(self.__url)

    def __init__(self, browser):
        self._web = Web(browser)

    def input_value_info_field(self, css_selector, keyword):
        self._web.get_web_element_by_css(css_selector).send_keys(keyword)

    def click_element(self, css_selector):
        self._web.get_web_element_by_css(css_selector).click()

    def find_element_value(self, css_selector):
        return self._web.get_web_element_by_css(css_selector).get_attribute('value')

    def close_browser(self):
        self._web.close_all()
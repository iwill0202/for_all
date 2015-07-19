# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re

class WebDriver(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://fyjud.lawbank.com.tw/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_web_driver(self):
        driver = self.driver
        driver.get(self.base_url + "/index.aspx")
        # ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(u"車")
        driver.find_element_by_id("jcatagory2").click()
        driver.find_element_by_id("jt").clear()
        driver.find_element_by_id("jt").send_keys(u"損害賠償")
        driver.find_element_by_css_selector("input[type=\"image\"]").click()
        # ERROR: Caught exception [ERROR: Unsupported command [selectFrame | contentFrame | ]]
        driver.find_element_by_link_text(u"102,訴,5011").click()
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException, e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException, e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
# -*- coding: utf-8 -*-
from selenium import selenium
import unittest, time, re

class test(unittest.TestCase):
    def setUp(self):
        self.verificationErrors = []
        self.selenium = selenium("localhost", 4444, "*chrome", "http://fyjud.lawbank.com.tw/")
        self.selenium.start()
    
    def test_test(self):
        sel = self.selenium
        sel.open("/index.aspx")
        sel.click("document.form1.courtFullName[21]")
        sel.type("id=kw", u"車")
        sel.click("id=jcatagory2")
        sel.type("id=jt", u"損害賠償")
        sel.click("css=input[type=\"image\"]")
        sel.wait_for_page_to_load("30000")
        sel.select_frame("contentFrame")
        sel.click(u"link=104,北小,157")
        sel.wait_for_page_to_load("30000")
    
    def tearDown(self):
        self.selenium.stop()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()

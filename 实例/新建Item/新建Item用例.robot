*** Settings ***
Resource          新建Item业务.txt
Library           SeleniumLibrary
Resource          新建Item元素.txt

*** Test Cases ***
新建Item成功
    新建Item
    ${rwmc1}    Get text    //*[@id="job_管理后台"]/td[3]/a
    should contain    ${rwmc1}    ${renwumingcheng}
    强制等待
    删除Item

Item名称为英文
    新建Item    master
    ${rwmc1}    Get text    //*[@id="job_master"]/td[3]/a
    should contain    ${rwmc1}    master
    强制等待
    删除Item

Item名称为数字
    新建Item    123
    ${rwmc1}    Get text    //*[@id="job_123"]/td[3]/a
    should contain    ${rwmc1}    123
    强制等待
    删除Item

选择Freestyle project
    新建Item    管理后台    ${number1}    ${baocun1}
    ${rwmc1}    Get text    //*[@id="job_管理后台"]/td[3]/a
    should contain    ${rwmc1}    ${renwumingcheng}
    强制等待
    删除Item

选择构建一个多配置项目
    新建Item    管理后台    ${number3}    ${baocun3}
    ${rwmc1}    Get text    //*[@id="job_管理后台"]/td[3]/a
    should contain    ${rwmc1}    ${renwumingcheng}
    强制等待
    删除Item

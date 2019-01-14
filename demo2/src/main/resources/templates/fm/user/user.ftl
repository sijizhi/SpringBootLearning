<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试freemarker</title>
</head>
<body>
    <h1>哈哈哈</h1>
    <h1>${setting.name}</h1>
    <p>${setting.password}</p>
    <#assign list=adv.list/>
    <#if !list?exists||list?size==0>
        集合不存在！
        <#else >
        <#list list as li>
            <p>${li}</p>
        </#list>
    </#if>
</body>
</html>
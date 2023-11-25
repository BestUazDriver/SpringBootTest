<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/common.css"/>
    <title>Welcome to main page</title>
</head>
<body>
<div class="main-content">
    <p>Hello</p>
    <table>
        <tr>
            <th>Car</th>
            <th>Horse Power</th>
        </tr>
        <#list cars as i>
            <tr>
                <td>${i.getName()!"Unknown"}</td>
                <td>${i.getHorsePower()!"Unknown"}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
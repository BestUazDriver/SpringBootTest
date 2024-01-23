<!DOCTYPE html>
<html lang="ru">
<head>
    <title>User Info</title>
    <!-- Добавьте здесь любые необходимые CSS стили или ссылки -->
</head>
<body>
<h1>User Information</h1>

<!-- Проверка, существует ли объект user в модели -->
<#if user??>
    <div>
        <h2>Details:</h2>
        <p><strong>Name:</strong> ${user}</p>
        <!-- Добавьте дополнительные поля, если это необходимо -->
    </div>
<#else>
    <p>User data is not available.</p>
</#if>

<!-- Дополнительный контент можно добавить здесь -->
</body>
</html>
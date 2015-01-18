<html>
    <head>
        <title>
            Fruit Piker Form Test
        </title>
    </head>
    <body>

        <form action="/favorite_fruit" method="POST">
            <#list fruits as fruit>
            <p>
                <input type="radio" name="fruit" value="${fruit}">${fruit}</input>
            </p>
            </#list>
            <input type="submit" value="Submit">

            </input>

        </form>
    </body>
    </html>


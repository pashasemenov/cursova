<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-color: lightpink;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="purchase" action="" method="POST">
    Product code:
    <br>
    <@spring.formInput "purchaseForm.productCode" "" "text"/>
    <br>
    Client code:
    <br>
    <@spring.formInput "purchaseForm.clientCode", "", "text"/>
    <br>
    Date :
    <br>
    <@spring.formInput "purchaseForm.date", "", "text"/>
    <br>
    Delivery:
    <br>
    <@spring.formInput "purchaseForm.delivery", "", "text"/>
    <br>
    Type of payment
    <br>
    <@spring.formInput "purchaseForm.typeOfPayment", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Purchase list</h3>
<br>
<div>
    <fieldset>
        <form name="search" action="" method="POST">
            <div class="search">
                Purchase model:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
            </div>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<br>

<a href="/" type="button" class="btn btn-light" style="float:left; margin-top:5px;"><i class="fa fa-chevron-circle-left"></i>Back to home page</a>

<a href="/web/purchase/create" type="button" class="btn btn-light" style="float:right; margin-top:5px;"><i class="fa fa-plus-square-o"></i>Add new coup</a>

<br>

<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Product code<a href="/web/purchase/list/sorted" type="button" class="btn btn-outline-light">
                                                                     <i class="fa fa-sort-alpha-asc"></i></a> <a href="/web/purchase/list" type="button" class="btn btn-outline-light">
                                                                     <i class="fa fa-undo"></i>Undo sort</a></th>
            <th>Client code</th>
            <th>Date</th>
            <th>Delivery</th>
            <th>TypeOfPayment</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list purchase as purchase>
            <tr>
                <td>${purchase.id}</td>
                <td>${purchase.productCode}</td>
                <td>${purchase.clientCode}</td>
                <td>${purchase.date}</td>
                <td>${purchase.delivery}</td>
                <td>${purchase.typeOfPayment}</td>
                <td><a href="delete/${purchase.id}"><button>Delete</button></a></td>
                <td><a href="/web/purchase/edit/${purchase.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Employees list</h3>
<br>
<div>
    <fieldset>
        <form name="search" action="" method="POST">
            <div class="search">
                Employees model:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
            </div>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<br>

<a href="/" type="button" class="btn btn-light" style="float:left; margin-top:5px;"><i class="fa fa-chevron-circle-left"></i>Back to home page</a>

<a href="/web/employees/create" type="button" class="btn btn-light" style="float:right; margin-top:5px;"><i class="fa fa-plus-square-o"></i>Add new</a>

<br>

<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Surname<a href="/web/employees/list/sorted" type="button" class="btn btn-outline-light">
                                                                <i class="fa fa-sort-alpha-asc"></i></a> <a href="/web/employees/list" type="button" class="btn btn-outline-light">
                                                                <i class="fa fa-undo"></i>Undo sort</a></th>
            <th>Name</th>
            <th>Patronymic</th>
            <th>Position</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list employees as employees>
            <tr>
                <td>${employees.id}</td>
                <td>${employees.surname}</td>
                <td>${employees.name}</td>
                <td>${employees.patronymic}</td>
                <td>${employees.position}</td>
                <td>${employees.address}</td>
                <td>${employees.phone}</td>
                <td><a href="/web/employees/delete/${employees.id}"><button>Delete</button></a></td>
                <td><a href="/web/employees/edit/${employees.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>
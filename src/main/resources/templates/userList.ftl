<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <div>Список юзеров</div>

    <div>
        <form method="get" action="/user/userList">
            <input type="text" name="findName" placeholder="find with user FirstName" value="${filter!}">

            <button type="submit">Find user</button>
        </form>
    </div>
    <table>
        <thead>
        <tr>
            <th><a href="/user/sortBy/${"firstName"}">First name</a></th>
            <th>Email</th>
            <th>Password</th>
            <th><a href="/user/sortBy/${"active"}">Active</a></th>
            <th><a href="/user/sortBy/${"roleType"}">Role</a></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users! as usr>
            <tr>
                <td>${usr.firstName}</td>
                <td>${usr.email}</td>
                <td>${usr.password}</td>
                <td>${usr.active?then('Active','Not active')}</td>
                <td>${usr.roleType}</td>
                <td><a href="/registration/${usr.id}">Edit</a> </td>
            </tr>
        <#else >
            No user
        </#list>
        </tbody>
    </table>

</@mymacro.page>

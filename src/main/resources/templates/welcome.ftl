<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if><#if isSpeaker>you are Speaker !</#if></h5>
    You are on Conference portal,<br> here you could view conferences and check for visit
    <br>
    <#if isAdmin>
        <#include "parts/datePicker.ftl">
    </#if>
    <div class="card-columns">
        <#list conferences! as conference>
            <div class="card my-3">
                <div class="m-2" <#if conference.date.isBefore(dateNow)> style="color: brown" </#if>>
                    <div class="row">
                        <div class="col align-self-center"> ${conference.date}</div>
                        <div class="col align-self-center"> ${conference.subject}</div>
                        <#if isAdmin>
                            <div class="col align-self-center"><a href="/conference/${conference.id}">Edit</a></div>
                        </#if>
                        <#if (isSpeaker && conference.date.isAfter(dateNow))>
                            <div class="col align-self-center"><a href="/presentation/${conference.id}">
                                    Add presentation</a></div>
                        </#if>
                    </div>
                </div>

                <div class="card-footer text-muted">
                    <table>
                        <thead>
                        <tr>
                            <th>Speaker</th>
                            <th>Theme</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list conference.presentations! as presentation>
                            <tr>
                            <td>${presentation.author.firstName}</td>
                            <td>${presentation.theme}</td>
                            <#if (presentation.author.id==currentUserId || isAdmin)>
                                <td><a href="/presentation/${conference.id}?presentation=${presentation.id}">Edit </a></td>
                            </#if>
                            </tr>
                        <#else>
                            No presentations
                        </#list>
                        </tbody>
                    </table>

                </div>
            </div>
        <#else >
            No conferences
        </#list>
    </div>


</@mymacro.page>

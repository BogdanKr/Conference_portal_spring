<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if><#if isSpeaker>you are Speaker !</#if></h5>
    You are on Conference portal,<br> here you could view conferences and check for visit
    <br>
    <#if isAdmin>
        <#include "parts/datePicker.ftl">
    </#if>


    <div class="card-columns" >
        <#list conferences! as conference>
            <div class="card<#if conference.date.isBefore(dateNow)> text-white bg-secondary mb-3 </#if>">
                <div class="card-header ">
                    <div class="row">
                        <div class="col-5"> ${conference.date}</div>
                        <div class="col"> ${conference.subject}</div>
                        <#if isAdmin>
                            <div class="col-md-autor"><a href="/conference/${conference.id}">Edit</a></div>
                        </#if>
                        <#if (isSpeaker && conference.date.isAfter(dateNow))>
                            <div class="col-md-auto"><a href="/presentation/${conference.id}">
                                    Add presentation</a></div>
                        </#if>
                    </div>
                </div>

                <div class="card-body ">
                    <table class="table table-hover table-sm">
                        <thead>
                        <tr>
                            <th>Speaker</th>
                            <th style="padding-left: 10px">Theme</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody style="color: blue">
                        <#list conference.presentations! as presentation>
                            <tr>
                                <td>${presentation.author.firstName}</td>
                                <td>${presentation.theme}</td>
                                <#if (presentation.author.id==currentUserId || isAdmin)>
                                    <td style="text-align: right">
                                        <a href="/presentation/${conference.id}?presentation=${presentation.id}">Edit </a>
                                    </td>
                                </#if>


                            </tr>
                        <#else>
                            No presentations
                        </#list>
                        </tbody>
                    </table>

                </div>
                <div class="card-footer ">
                    <div class="row">
                        <div class="col-8">
                            <a href="/conference/${conference.id}/like" style="color: #b10821">
                                <#if conference.meRegistered>
                                    <i class="fas fa-registered">Registrated </i>
                                <#else>
                                    <i class="far fa-registered"> </i>
                                </#if>
                            </a>
                        </div>
                        <div class="col-4">
                            ${conference.registrations}
                        </div>
                    </div>
                </div>
            </div>
        <#else >
            No conferences
        </#list>
    </div>



</@mymacro.page>

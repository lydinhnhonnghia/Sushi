/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function KeepHightlight() {
    var list = document.getElementById("menu").getElementsByTagName("a");
    for (var i = 0; i < list.length; i++) {
        if (list[i].href === window.location.href) {
            if (i === 0 || i === 1) {
                continue;
            }
            list[i].className += " keepHightLight-link";
            break;
        }
    }
}

function KeepLink() {
    var menu = document.getElementById("menu").getElementsByTagName("a");
    var check = false;
    var actualPage;
    var menuIndex;
    if(document.getElementById("homePage")!==null){
        actualPage=document.getElementById("homePage").getElementsByTagName("a");
        menuIndex=0;
    }else{
        actualPage=document.getElementById("listPage").getElementsByTagName("a");
        menuIndex=1;
    }

    for (var i = 0; i < actualPage.length; i++) {
        if (actualPage[i].href === window.location.href) {
            actualPage[i].className += " disabled-link";
            menu[menuIndex].className += " keepHightLight-link";
            check = true;
            break;
        }
    }
    if (check === false) {
        actualPage[0].className += " disabled-link";
        menu[menuIndex].className += " keepHightLight-link";
    }
}
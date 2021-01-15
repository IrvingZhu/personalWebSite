/*
 * @Description: 
 * @version: 
 * @Author: zrz
 * @Date: 2021-01-04 19:46:21
 * @LastEditors: zrz
 * @LastEditTime: 2021-01-05 12:12:28
 */

function onMoveOver(){
    document.qq_img.src = "./image/QQ_2_dim_code.png";
}

function onMoveOut(){
    document.qq_img.src = "./image/penguin.jpg";
}

// function onClick(){
//     var tag = 0;
//     var img_ = document.getElementsByName("qq_img");
//     img_.onclick = function(){
//         if(tag == 0){
//             img_.src = "./image/QQ_2_dim_code.png"
//             tag = 1;
//         }else{
//             img_.src = "./image/penguin.jpg"
//             tag = 0;
//         }
//     }
// }

function onMoveOver_wechat(){
    document.wechat_img.src = "./image/wechat_2_dim_code.png";
}

function onMoveOut_wechat(){
    document.wechat_img.src = "./image/wechat.png";
}
//----팔로워 모달-----------------
let body2 = document.querySelector("body");
let followerMd = document.querySelector('.followerMd');
let flwerBtn = document.getElementById("flwerBtn");

function flwerMdOpen() {
  followerMd.style.display = 'block';
  body2.style.overflow = "hidden";
}
function flwerMdClose() {
  followerMd.style.display = "none";
  body2.style.overflow = "auto";
}

// 클릭시 모달오픈
flwerBtn.addEventListener('click', flwerMdOpen);

// 외부 클릭시 모달창닫음
window.addEventListener('click', (e) => {
  e.target === followerMd ? flwerMdClose() : false
})

//----팔로잉 모달-----------------
let body3 = document.querySelector("body");
let followingMd = document.querySelector('.followingMd');
let flwingBtn = document.getElementById("flwingBtn");

function flwingMdOpen() {
  followingMd.style.display = 'block';
  body3.style.overflow = "hidden";
}
function flwingMdClose() {
  followingMd.style.display = "none";
  body3.style.overflow = "auto";
}

// 클릭시 모달오픈
flwingBtn.addEventListener('click', flwingMdOpen);

// 외부 클릭시 모달창닫음
window.addEventListener('click', (e) => {
  e.target === followingMd ? flwingMdClose() : false
})
// 1. 유저가 값을 입력한다.
// 2. +버튼을 클릭하면, 할일이 추가된다. 
// 3. delete버튼을 누르면 할일이 삭제된다.
// 4. check버튼을 누르면 (addEventListener) 할일이 끝나면서 취소선이 그어진다.
    //check버튼을 클릭하는 순간 true가 false로, false가 true로.
    //true이면 끝난걸로 간주하고 취소선이 그어진다.
    //false이면 끝나지 않은 걸로 간주하고 그대로 보여준다.
// 5. 진행중, 끝남 탭을 누르면 할일이 끝나면서 언더바가 이동한다. 
// 6. 끝남탭은 끝난 아이템만, 진행중 탭은 진행중인 아이템만 보여준다. 
// 7. 전체탭을 누르면 다시 전체 아이템으로 돌아온다.
// 함수입장에서는 어떤 아이템을 눌렀는지 알 수 없음. 내가 누굴 선택했는지 알아야 그 아이템만 취소선을 그을 수 있음. so 아이디를 달아야.

// const uniqueId = Math.random().toString(36).substr(2,9);

let taskInput = document.getElementById("task-input");
console.log(taskInput); //콘솔로 틈틈이 확인해보기

let addButton = document.getElementById("add-button");
let tabs = document.querySelectorAll("#task-tabs div");
let taskList = [];
let mode = "all";
let filterList = [];


addButton.addEventListener("click", addTask);

//div첫번째꺼는 필요없기 때문에 두번재부터 시작하려면 i=1부터시작.
for(let i=1; i < tabs.length; i++) {
    tabs[i].addEventListener("click", function(event)
    {filter(event)})
}
console.log(tabs); //for문 없었을때는 div 네개가 잡힘
function addTask(){
    // console.log("click되는지 확인해 볼까요?");
    let task = {
        id: randomIdGenerate(),
        taskContent : taskInput.value,
        isComplete : false
    } //객체로만듦.
    taskList.push(task);
    console.log(taskList);

    render();

}

// 화면단에 표현하는 역할
function render(){
    let list = [];
    if(mode == "all") {
        list = taskList;
    } else if (mode == "ongoing" || mode == "done"){
        list = filterList;
    }
    let resultHTML = "";
    for (i = 0; i < list.length; i++){
        if (list[i].isComplete == true){
             resultHTML += `<div class="task">
        <div class="task-done">${list[i].taskContent}</div>
        <div>
            <button onclick="toggleComplete('${list[i].id}')">Check</button>
            <button onclick="deleteTask('${list[i].id}')">Delete</button>
        </div>
    </div>`;
        // 숫자 1옆에있는. 동작을 넣음.
    } else {
        resultHTML += `<div class="task">
        <div>${list[i].taskContent}</div>
        <div>
            <button onclick="toggleComplete('${list[i].id}')">Check</button>
            <button onclick="deleteTask('${list[i].id}')">Delete</button>
        </div>
    </div>`;
    }
    }
       
    document.getElementById("task-board").innerHTML = resultHTML;
} 

function toggleComplete(id) {
    // console.log("체크되었나요?")
    for(let i = 0; i < taskList.length; i++) {
        if(taskList[i].id == id) {
            taskList[i].isComplete = !taskList[i].isComplete; //not 이러면 toggle이랑 똑같
            break;
        }
    }
    render();
    console.log(taskList);
}

function randomIdGenerate() {
    return Math.random().toString(36).substr(2, 9);
} //랜덤으로 아이디 생성

function deleteTask(id){
    // console.log("삭제될까요?");
    for(let i = 0; i < taskList.length; i++) {
        if (taskList[i].id == id) {
            taskList.splice(i, 1)
            break;
        }
    }
    // console.log(taskList);
    render();
}

function filter(event){
    // console.log("클릭이 되는지 확인", event.target.id);
    filterList = [];
    mode = event.target.id;
    if (mode == "all") {
        render();
    } else if (mode == "ongoing"){
        for(let i=0; i < taskList.length; i++) {
            if(taskList[i].isComplete == false) { 
                filterList.push(taskList[i]);
            }
        }
        console.log(filterList);
    } else if (mode == "done"){
        for(let i=0; i < taskList.length; i++) {
            if(taskList[i].isComplete == true) {
                filterList.push(taskList[i]);
            }
        } 
        console.log(filterList);
    }
    render();
}
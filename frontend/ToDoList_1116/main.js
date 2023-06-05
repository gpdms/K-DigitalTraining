// 1. 유저가 값을 입력한다.
// 2. + 버튼을 클릭하면, 할일이 추가되어진다.
// 3. delete 버튼을 누르면 할일이 삭제되어진다.
// 4. check 버튼을 누르면 할일이 끝나면서 취소선이 그어진다.
     // check버튼을 클릭하는 순간 true false로 false가 true
     // true이면 끝난걸로 간주하고 취소선이 그어진다.
     // false이면 안끝난걸로 간주하고 그대로 보여준다..

// 5. 진행중, 끝남 탭을 누르면 할일이 끝나면서 ,언더바가 이동한다.
// 6. 끝남탭은, 끝난 아이템만, 진행중인 탭은 진행중인 아이템만
// 7. 전체탭을 누르면 다시 전체 아이템으로 돌아옴.
// 함수 입장에서는 어떤 아이템을 눌렀는지 어떻게 알수가 있냐구요???
// 내가 누굴 선택했는지 알아야 그 아이템만 취소선을 그릴 수 있게 될것입니다.....

// const uniqueId = Math.random().toString(36).substr(2, 9);

let taskInput = document.getElementById("task-input");
console.log(taskInput);
let addButton = document.getElementById("add-button");
let taskList = [];

addButton.addEventListener("click", addTask);

function addTask(){
    // console.log("click되는지 확인해 볼까요????");
    let task = {
      id:randomIdGenerate(),
      taskContent : taskInput.value,
      isComplete : false
    }
    taskList.push(task);
    console.log(taskList);

    render();
}

function render() {
    let resultHTML = "";
    for (i = 0; i < taskList.length; i++) {
        if (taskList[i].isComplete == true) {
          resultHTML += `<div class="task">
        <div class="task-done">${taskList[i].taskContent}</div>
        <div>
          <button onclick="toggleComplete('${taskList[i].id}')">Check</button>
          <button>Delete</button>
        </div>
      </div>`;
    } else {
      resultHTML += `<div class="task">
        <div>${taskList[i].taskContent}</div>
        <div>
          <button onclick="toggleComplete('${taskList[i].id}')">Check</button>
          <button onclick="deleteTask()">Delete</button>
        </div>
      </div>`;
    }
  }
        
    document.getElementById("task-board").innerHTML = resultHTML;
}

function toggleComplete(id) {
  // console.log("체크되었나요? 안되었나요? 에러가없기를")
  for(let i = 0; i < taskList.length; i++) {
    if(taskList[i].id == id) {
       taskList[i].isComplete = !taskList[i].isComplete;
       break;
    }
  }
  render();
  console.log(taskList)
}

function randomIdGenerate() {
  return Math.random().toString(36).substr(2, 9);
}

function deleteTask() {
  
}
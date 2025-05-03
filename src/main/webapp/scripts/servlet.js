const addFormHidden = document.querySelector(".addFormHidden");
const showAddForm = document.querySelector(".showAddForm");

showAddForm.addEventListener("click", () => {
  addFormHidden.classList.toggle("addFormShown");
  showAddForm.classList.toggle("hideFormBtn");
  document.body.querySelector("main").classList.toggle("disabled");
});

const options = document.querySelectorAll(".sort_by_option");
const inputField = document.querySelector(".sort_by_inputField");
const optionsDiv = document.querySelector(".options_div_hidden");
const sortByInputFieldDiv = document.querySelector(".sort_by_inputField_div");
const dropdownIcon = document.querySelector(".dropdown_icon");

const filterByGenderDropdownDiv = document.querySelector(
  ".filter_by_gender_dropdown_div"
);
const filterByGenderDropdownIcon = document.querySelector(
  ".filter_by_gender_dropdown_icon"
);

const genderRadios = document.querySelector(".gender_radios_hidden");

sortByInputFieldDiv.addEventListener("click", () => {
  dropdown(
    dropdownIcon,
    optionsDiv,
    "dropdown_icon_clicked",
    "options_div_revealed"
  );
});

filterByGenderDropdownDiv.addEventListener("click", () => {
  dropdown(
    filterByGenderDropdownIcon,
    genderRadios,
    "filter_by_gender_dropdown_icon_rotated",
    "gender_radios_revealed"
  );
});

function dropdown(icon, revealed, iconClass, revealedClass) {
  icon.classList.toggle(iconClass);
  revealed.classList.toggle(revealedClass);
}

options.forEach((option) => {
  option.addEventListener("click", () => {
    inputField.value = option.textContent;
    inputField.setAttribute("value", option.textContent);
    optionsDiv.setAttribute("class", "options_div_hidden");
  });
});

const firstCols = document.querySelectorAll(
  "tr>td:first-child, tr>th:first-child"
);
const selectBtn = document.querySelector(".select");
const discardSelectionBtn = document.querySelector(".discard_select");
const deleteBtn = document.querySelector(".delete");

selectBtn.addEventListener("click", () => {
  discardSelectionBtn.style.display = "inline-block";

  firstCols.forEach((firstCol) => {
    firstCol.style.display = "block";
  });
});

discardSelectionBtn.addEventListener("click", () => {
  discardSelectionBtn.style.display = "none";

  firstCols.forEach((firstCol) => {
    firstCol.style.display = "none";
  });
});

const editFormHidden = document.querySelector(".edit_form_div_hidden");
const showEditForm = document.querySelector(".edit-action");
const hideEditForm = document.querySelector(".hide_edit_form");

showEditForm.addEventListener("click", () => {
  editFormHidden.classList.add("edit_form_div_shown");
  document.body.querySelector("main").classList.add("disabled");
});

hideEditForm.addEventListener("click", () => {
  editFormHidden.classList.remove("edit_form_div_shown");
  document.body.querySelector("main").classList.remove("disabled");
});

const viewFormHidden = document.querySelector(".view_form_div_hidden");
const showViewForm = document.querySelector(".view-action");
const hideViewForm = document.querySelector(".hide_view_form");

showViewForm.addEventListener("click", () => {
  viewFormHidden.classList.add("view_form_div_shown");
  document.body.querySelector("main").classList.add("disabled");
});

hideViewForm.addEventListener("click", () => {
  viewFormHidden.classList.remove("view_form_div_shown");
  document.body.querySelector("main").classList.remove("disabled");
});

const rows = document.querySelectorAll(".table-row");
const actions = document.querySelector(".actions-hidden");

rows.forEach((row) => {
  row.addEventListener("dblclick", () => {
    viewFormHidden.classList.add("view_form_div_shown");
    document.body.querySelector("main").classList.add("disabled");
  });

  row.addEventListener("contextmenu", (e) => {
    e.preventDefault();
    actions.classList.add("actions-shown");
    actions.style.top = e.clientY + "px";
    actions.style.left = e.clientX + "px";
  });

  document.addEventListener("click", (e) => {
    if (!row.contains(e.target)) {
      actions.classList.remove("actions-shown");
    }
  });
});

const deleteOption = document.querySelector(".delete-action");
const deleteConfirm = document.querySelector(".hiddenDeleteForm");

const cancelBtn = document.querySelector(".cancel-btn");

deleteOption.addEventListener("click", (e) => {
  deleteConfirm.classList.add("revealedDeleteForm");
  deleteConfirm.style.top = e.clientY + "px";
  deleteConfirm.style.left = e.clientX + "px";
  console.log(e.clientX + "px");
  console.log(e.clientY + "px");
  document.body.querySelector("main").classList.add("disabled");
});

cancelBtn.addEventListener("click", () => {
  deleteConfirm.classList.remove("revealedDeleteForm");
  document.body.querySelector("main").classList.remove("disabled");
  console.log(deleteConfirm.classList);
});

const table = document.querySelector("table");

const tableRows = table.querySelectorAll(".table-row");
const deleteIdField = document.querySelector(".id-field");

const events = ["click", "contextmenu", "dblclick"];

let selected = {};

const selectedIds = document.querySelectorAll(".selectedId");
const selectedFirstName = document.querySelector(".selectedFirstName");
const selectedLastName = document.querySelector(".selectedLastName");
const selectedGender = document.querySelector(".selectedGender");
const selectedDateOfBirth = document.querySelector(".selectedDateOfBirth");
const selectedCreatedAt = document.querySelector(".selectedCreatedAt");

tableRows.forEach((tableRow) => {
  events.forEach((eve) => {
    tableRow.addEventListener(eve, () => {
      const cells = tableRow.querySelectorAll("td");

      selected["id"] = cells[1].innerText;
      selected["firstName"] = cells[2].innerText;
      selected["lastName"] = cells[3].innerText;
      selected["gender"] = cells[4].innerText;
      selected["dateOfBirth"] = cells[5].innerText;
      selected["createdAt"] = cells[6].innerText;
      console.log(cells[1].innerText);

      selectedIds.forEach((selectedId) => {
        selectedId.innerHTML = selected["id"];
        selectedId.value = selected["id"];
      });

      selectedFirstName.innerHTML = selected["firstName"];
      selectedLastName.innerHTML = selected["lastName"];
      selectedGender.innerHTML = selected["gender"];
      selectedDateOfBirth.innerHTML = selected["dateOfBirth"];
      selectedCreatedAt.innerHTML = selected["createdAt"];
    });
  });
});

const items = document.querySelectorAll(".items");
const selectAll = document.querySelector(".selectAll");
selectAll.addEventListener("change", () => {
  console.log(selectAll.checked);
  items.forEach((item) => {
    console.log(item);
    item.checked = selectAll.checked;
    item.dispatchEvent(new Event("change"));
  });
});

let checkeds = null;
items.forEach((item) => {
  item.addEventListener("change", () => {
    checkeds = document.querySelectorAll(".items:checked");
    let checkedIds = Array.from(checkeds).map((ch) => ch.value);
    if (checkedIds.length > 0) {
      deleteBtn.style.display = "inline-block";
    } else {
      deleteBtn.style.display = "none";
    }
  });
});


const dateOfBirthFields = document.querySelectorAll(".addForm_birthdate_field");

dateOfBirthFields.forEach((dateOfBirthField) => {
  const today = new Date();

  let fiveYearsAgo = new Date(
    today.getFullYear() - 5,
    today.getMonth(),
    today.getDate()
  );
  let hundredTenYearsAgo = new Date(
    today.getFullYear() - 110,
    today.getMonth(),
    today.getDate()
  );

  dateOfBirthField.min = hundredTenYearsAgo.toISOString().split("T")[0];
  dateOfBirthField.max = fiveYearsAgo.toISOString().split("T")[0];

});

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
  



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Management System</title>
    <link rel="stylesheet" href="styles/servlet.css?v=1.2" />
    <link rel="stylesheet" href="styles/addForm.css?v=1.2" />
    <link rel="stylesheet" href="styles/table.css?v=1.2" />
    <link rel="stylesheet" href="styles/editForm.css?v=1.2" />
    <link rel="stylesheet" href="styles/viewForm.css?v=1.2" />
    <link rel="stylesheet" href="styles/deleteForm.css?v=1.2" />
    
  </head>
  <body>
    <header style="padding: 10px; display: flex; align-items: center;">
    
    <h2 style="color: white;">USER MANAGEMENT SYSTEM</h2>
    
    </header>
    <main>
      <section class="left">
      
        <form class="sort_form" action="UsersServlet">
          <div class="sort_by_inputField_div">
            <input
              class="sort_by_inputField"
              value="${searchBy}"
              type="text"
              placeholder="Serach by"
              form="search_form"
              name="searchByField" required
              
            />
            <img class="dropdown_icon" src="icons/chevron-down.png" alt="" />
          </div>
          <div class="options_div_hidden">
            <p class="sort_by_option">id</p>
            <p class="sort_by_option">first_name</p>
            <p class="sort_by_option">last_name</p>
            <p class="sort_by_option">date_of_birth</p>
            <p class="sort_by_option">created_at</p>
          </div>

          <div class="filter_by_gender_div">
            <div class="filter_by_gender_dropdown_div">
              <p>Gender</p>
              <img
                class="filter_by_gender_dropdown_icon"
                src="icons/chevron-down.png"
                alt=""
              />
            </div>
            
            

            <div class="gender_radios_hidden">
              <label class="gender_radio" for="all_radio">
                <input
                  name="filter_by_gender"
                  title="All genders"
                  type="radio"
                  value=""
                  <%= "".equals(request.getAttribute("gender")) ? "checked" : "" %>
                  onchange="this.form.submit()"
                />All</label
              >
              <label class="gender_radio" for="male_radio"
                ><input
                  type="radio"
                  value="male"
                  name="filter_by_gender"
                  title="Males"
                  <%= "male".equals(request.getAttribute("gender")) ? "checked" : "" %>
                  onchange="this.form.submit()"
                  
                />Males</label
              >
              <label class="gender_radio" for="female_radio"
                ><input
                  title="Females"
                  type="radio"
                  value="female"
                  name="filter_by_gender"
                  <%= "female".equals(request.getAttribute("gender")) ? "checked" : "" %>
                  onchange="this.form.submit()"
                />Females</label
              >
            </div>
          </div>
        </form>
      </section>
      <section class="right">
        <div class="top">
          <div class="showAddForm">
            <div class="vertical"></div>
            <div class="horizontal"></div>
          </div>
          <form class="search_form" id="search_form" action="UsersServlet" method="get">
            <input class="search_field" type="search" placeholder="search" name="searchField" value="${search}" />
            <button title="Search" type="submit">
              <img src="icons/search.png" alt="" />
            </button>
          </form>
          <div class="select_div">
          <button type="submit" form="select_form" class="delete">
              Delete selected items
            </button>
          
            <button type="reset" form="select_form" class="discard_select">
              Discard select
            </button>
            <button class="select">Select</button>
          </div>
        </div>

        <table>
          <form id="select_form" action="DeleteSelected" method="post">
            <tr class="table-header">
              <th>
                <input title="select" type="checkbox" class="selectAll" />
              </th>
              <th>ID</th>
              <th>First name</th>
              <th>Last name</th>
              <th>Gender</th>
              <th>Date of birth</th>
              <th>Registered at</th>
            </tr>

<c:forEach var="user" items="${users}">
            <tr class="table-row">
              <td><input title="select" type="checkbox" name="selected" class="items" value="<c:out value = "${user.getId()}" />" /></td>
              <td><c:out value = "${user.getId()}" /></td>
<td><c:out value = "${user.getFirstName()}" /></td>
<td><c:out value = "${user.getLastName()}" /></td>
<td><c:out value = "${user.getGender()}" /></td>
<td><c:out value = "${user.getDateOfBirth()}" /></td>
<td><c:out value = "${user.getCreatedAt()}" /></td>
            </tr>
            
            </c:forEach>

            
          </form>
        </table>

        
      </section>
      
    </main>
    
    <form class="addFormHidden addForm" action="AddServlet" method="post">
          <h1 class="addFormHeading">Add new user</h1>
          <input name="firstName"
            class="addForm_firstName_field"
            type="text"
            placeholder="Enter first name"
          required />
          <input name="lastName"
            class="addForm_lastName_field"
            type="text"
            placeholder="Enter last name" required
          />
          <select class="addForm_gender_field" title="Gender" name="gender" required >
            <option disabled selected>Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
          </select>
          <input name="dateOfBirth"
            class="addForm_birthdate_field"
            type="date"
            placeholder="Choose Birthday" required
          />

          <button class="addBtn" type="submit">Add</button>
        </form>

        <div class="edit_form_div_hidden">
          <div class="hide_edit_form">
            <div class="vertical"></div>
            <div class="horizontal"></div>
          </div>
          <form class="editFormHidden editForm" action="UpdateServlet" method="post">
            <h1 class="editFormHeading">Edit user with id
            
            <input
            name="id"
            title="id"
            class="editIdField selectedId"
            type="number"
            readonly
          />
            </h1>
            <input
            name="firstName"
              class="editForm_firstName_field"
              type="text"
              placeholder="Enter first name"
            />
            <input
            name="lastName"
              class="editForm_lastName_field"
              type="text"
              placeholder="Enter last name"
            />
            <select class="editForm_gender_field" title="Gender" name="gender" id="">
              <option disabled selected>Gender</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
            <input
            name="dateOfBirth"
              class="editForm_birthdate_field addForm_birthdate_field"
              type="date"
              placeholder="Choose Birthday"
            />

            <button class="editBtn" type="submit">Update</button>
          </form>
        </div>

        <form class="hiddenDeleteForm" action="DeleteServlet" method="post">
          <label
            >Are you sure you want to delete the user with id
            <input class="id-field selectedId" name="deletedId" type="number" value="" readonly />?
          </label>
          <div class="buttons">
            <input class="delete-btn btn" type="submit" value="Delete" />
            <input class="cancel-btn btn" type="button" value="Cancel" />
          </div>
        </form>

        <div class="view_form_div_hidden">
          <div class="hide_view_form">
            <div class="vertical"></div>
            <div class="horizontal"></div>
          </div>
          <form class="viewFormHidden viewForm" action="">
            <p><b>ID: </b> <span class="selectedId"></span></p>
        <p><b>Names: </b> <span class="selectedFirstName"></span></p>
        <p><b>Email: </b> <span class="selectedLastName"></span></p>
        <p><b>Gender: </b> <span class="selectedGender"></span></p>
        <p><b>Date of birth: </b> <span class="selectedDateOfBirth"></span></p>
        <p><b>Created at: </b> <span class="selectedCreatedAt"></span></p>
          </form>
        </div>

        <ul class="actions-hidden">
          <li class="action edit-action">Edit</li>
          <li class="action view-action">View</li>
          <li class="action delete-action">Delete</li>
        </ul>

    <script src="scripts/servlet.js?v=1.2"></script>
  </body>
</html>

let apiUrl = '/drivers';

async function getLicenses() {
    try {
        let response = await fetch(apiUrl);
        let data = await response.json();
        return data;
    } catch (error) {
        console.log(error);
    }
}



// Assuming you have an array of objects called "list"


async function displayList(list) {
//    const list = [
//      {
//        fullName: "John Doe",
//        birthdate: "01/01/1980",
//        birthplace: "New York, NY",
//        issueDate: "01/01/2020",
//        expirationDate: "01/01/2030",
//        issuedBy: "Department of Motor Vehicles",
//        code: "ABC123",
//        residence: "123 Main St, Anytown USA",
//        categories: "A, B, C"
//      },
//      {
//        fullName: "Jane Smith",
//        birthdate: "02/02/1990",
//        birthplace: "Los Angeles, CA",
//        issueDate: "02/02/2020",
//        expirationDate: "02/02/2030",
//        issuedBy: "Department of Transportation",
//        code: "XYZ456",
//        residence: "456 Elm St, Anytown USA",
//        categories: "B, C"
//      }
//    ];


    const container = document.getElementById("list-container");

    // Loop through each object and create a list item
    list.forEach(obj => {
        const listItem = document.createElement("div");
        listItem.classList.add("list-item");

        const fullName = document.createElement("h2");
        fullName.innerText = obj.fullName;

        const birthdate = document.createElement("p");
        birthdate.innerHTML = `<strong>Birthdate:</strong> ${obj.birthdate}`;

        const birthplace = document.createElement("p");
        birthplace.innerHTML = `<strong>Birthplace:</strong> ${obj.birthplace}`;

        const issueDate = document.createElement("p");
        issueDate.innerHTML = `<strong>Issue Date:</strong> ${obj.issueDate}`;

        const expirationDate = document.createElement("p");
        expirationDate.innerHTML = `<strong>Expiration Date:</strong> ${obj.expirationDate}`;

        const issuedBy = document.createElement("p");
        issuedBy.innerHTML = `<strong>Issued By:</strong> ${obj.issuedBy}`;

        const code = document.createElement("p");
        code.innerHTML = `<strong>Code:</strong> ${obj.code}`;

        const residence = document.createElement("p");
        residence.innerHTML = `<strong>Residence:</strong> ${obj.residence}`;

        const categories = document.createElement("p");
        categories.classList.add("categories");
        categories.innerHTML = `<strong>Categories:</strong> ${obj.categories}`;

        listItem.appendChild(fullName);
        listItem.appendChild(birthdate);
        listItem.appendChild(birthplace);
        listItem.appendChild(issueDate);
        listItem.appendChild(expirationDate);
        listItem.appendChild(issuedBy);
        listItem.appendChild(code);
        listItem.appendChild(residence);
        listItem.appendChild(categories);

        container.appendChild(listItem);
    });
}



getLicenses().then(data => {
  displayList(data);
});
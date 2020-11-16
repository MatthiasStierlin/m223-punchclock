const URL = 'http://localhost:8081';
let entries = [];
let mode = 'create';
let currentEntry;

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (entry) => {
    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    });
};

const updateEntry = (entry) => {
    fetch(`${URL}/entries/${entry.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries = entries.map((e) => e.id === entry.id ? entry : e);
            renderEntries();
        });
    });
}

const saveForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    if (mode === 'create') {
        createEntry(entry);
    } else {
        entry.id = currentEntry.id;
        updateEntry(entry);
        mode = 'create';
    }
}

const editEntry = (entry) => {
    mode = 'edit';
    currentEntry = entry;
    alert(`You can now set the new data for Entry:${entry.id}`)

    const entryForm = document.querySelector('#entryForm');
    const checkInDateField = entryForm.querySelector('[name="checkInDate"]');
    checkInDateField.value = entry.checkIn.split('T')[0];
    const checkInTimeField = entryForm.querySelector('[name="checkInTime"]');
    checkInTimeField.value = entry.checkIn.split('T')[1].slice(0, -3);
    const checkOutDateField = entryForm.querySelector('[name="checkOutDate"]');
    checkOutDateField.value = entry.checkOut.split('T')[0];
    const checkOutTimeField = entryForm.querySelector('[name="checkOutTime"]');
    checkOutTimeField.value = entry.checkOut.split('T')[1].slice(0, -3);
}

const deleteEntry = (id) => {
    fetch(`${URL}/entries/${id}`,{
        method: 'DELETE'
    }).then((result) => {
    indexEntries();
    });
};


const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const createDeleteButton = (entry) => {
    const cell = document.createElement('td');

    const deleteButton = document.createElement('button');
    deleteButton.innerText = 'Delete';
    deleteButton.addEventListener('click', () => deleteEntry(entry.id));
    cell.appendChild(deleteButton);

    return cell;
}

const createEditButton = (entry) => {
    const cell = document.createElement('td');

    const editButton = document.createElement('button');
    editButton.innerText = 'Edit';
    editButton.addEventListener('click', () => editEntry(entry));
    cell.appendChild(editButton);

    return cell;
}


const renderEntries = () => {
    document.getElementById("createEntryForm").reset();
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        row.appendChild(createEditButton(entry));
        row.appendChild(createDeleteButton(entry));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createEntryForm');
    createEntryForm.addEventListener('submit', saveForm);
    indexEntries();

    const login = document.querySelector('#login');
    login.addEventListener('submit', loginForm);

    const registration = document.querySelector('#registrationForm');
    registration.addEventListener('submit', registrationForm);

});

const loginForm = (applicationUser) => {
    applicationUser.preventDefault();
    const loginFormData = new FormData(applicationUser.target);
    const loginData = {};
    loginData['username'] = loginFormData.get('username');
    loginData['password'] = loginFormData.get('password');

    fetch(`${URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    }).then(() => {
            alert(`You are now logged in!`);
            document.getElementById("login").reset();
            renderEntries();
        });
};

const registrationForm = (newUser) => {
    newUser.preventDefault();
    const registrationFormData = new FormData(newUser.target);
    const registrationData = {};
    registrationData['username'] = registrationFormData.get('usernameReg');
    registrationData['password'] = registrationFormData.get('passwordReg');
    
    fetch(`${URL}/users/sign-up`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(registrationData)
    }).then(() => {
        alert(`You are now a registered user!`);
        document.getElementById("registrationForm").reset();
        renderEntries();
    });
};
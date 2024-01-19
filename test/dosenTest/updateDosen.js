//PUT Request dosen
const dosenNidn = '100001';
const updatedData = {
    nama : 'Siti',
    gender : 'P',
    prodi : 'TI',
    matkul : 'Logika Happy',
    alamat : 'Jl. Cibaraya Kidul'
};

fetch(`http://localhost:3000/dosen/${dosenNidn}`, {
    method : 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(updatedData)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.log('Error', error));

//handle response
function handleResponse(response) {
    if (response.ok) {
        return response.json();
    } else {
        throw new Error(`Request failed with status: ${response.status}`);
    }
}

//handle error
function handleError(error) {
    console.error('Request failed:', error.message);
}
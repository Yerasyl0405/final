fetch('http://localhost:8080/save-location', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(locationData),
})
.then(response => response.json())
.then(data => {
    alert(data.message);
})
.catch((error) => {
    console.error('Ошибка:', error);
});

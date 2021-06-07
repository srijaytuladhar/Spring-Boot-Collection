<h2>Add new Students</h2>

<form action="addStudent">
    <input type="text" name="id" placeholder="id"/ required><br>
    <input type="text" name="name" placeholder="name" required/><br>
    <input type="text" name="age" placeholder="age" required/><br>
    <input type="text" name="email" placeholder="email" required/><br>
    <input type="submit"/><br>
</form>

<hr>
<h2>Display Student by ID</h2>
<form action="getStudent">
    <input type="text" name="id" placeholder="id"/ required><br>
    <input type="submit"/><br>
</form>
<hr>
<h2>Student by ID</h2>
${student}
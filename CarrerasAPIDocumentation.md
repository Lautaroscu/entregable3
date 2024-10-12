# API Documentation - CarreraController

## Base URL
`/api/carreras`

## Endpoints

### 1. Get All Carreras
- **Method:** `GET`
- **Endpoint:** `/api/carreras`
- **Description:** Obtiene una lista de todas las carreras con la opción de ordenarlas por la cantidad de inscriptos y generar un reporte de las carreras, que para cada carrera incluya información de los
  inscriptos y egresados por año. Donde se ordenan las carreras alfabéticamente, y
  presenta los años de manera cronológica.
  .

#### Query Parameters:
- `sortByInscriptos` (optional): Si es `true`, ordena las carreras por la cantidad de inscriptos.
- - ejemplo : /api/carreras?sortByInscriptos=true
- `generarReporte` (optional): Si es `true`, genera un reporte.
- - ejemplo : /api/carreras?generarReporte=true


- (Son consultas excluyentes, es decir no podria solicitar ambos simultaneamente)

#### Responses:
- **200 OK:** Devuelve una lista de carreras.

---

### 2. Get Carrera by ID
- **Method:** `GET`
- **Endpoint:** `/api/carreras/{idCarrera}`
- **Description:** Obtiene una carrera específica por su ID.

#### Path Variables:
- `idCarrera`: El ID de la carrera a buscar.

#### Responses:
- **200 OK:** Devuelve la carrera encontrada.
- **404 Not Found:** Si no se encuentra una carrera con el ID proporcionado.

---

### 3. Add Carrera
- **Method:** `POST`
- **Endpoint:** `/api/carreras`
- **Description:** Crea una nueva carrera en la base de datos.

#### Request Body:
- **String nombre**: Nombre de la nueva carrera.

#### Responses:
- **201 Created:** Devuelve la carrera creada.
- **400 Bad Request:** Si hay un error en los datos proporcionados.

---

### 4. Update Carrera
- **Method:** `PUT`
- **Endpoint:** `/api/carreras/{idCarrera}`
- **Description:** Actualiza la información de una carrera existente.

#### Path Variables:
- `idCarrera`: El ID de la carrera a actualizar.

#### Request Body:
- **String nombre**: Nuevo nombre de la carrera.

#### Responses:
- **201 Created:** Devuelve la carrera actualizada.
- **404 Not Found:** Si no se encuentra una carrera con el ID proporcionado.
- **400 Bad Request:** Si hay un error en los datos proporcionados.

---

### 5. Delete Carrera
- **Method:** `DELETE`
- **Endpoint:** `/api/carreras/{idCarrera}`
- **Description:** Elimina una carrera específica por su ID.

#### Path Variables:
- `idCarrera`: El ID de la carrera a eliminar.

#### Responses:
- **200 OK:** Mensaje indicando que la carrera fue eliminada exitosamente.
- **404 Not Found:** Si no se encuentra una carrera con el ID proporcionado.

---

## Error Handling
Los errores se manejan mediante excepciones personalizadas, que devuelven un mensaje descriptivo y un código de estado HTTP adecuado.


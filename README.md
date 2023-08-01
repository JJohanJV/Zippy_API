# Zippy_API
Desarrollo del backend con RESTAPIs en SpringBoot para Zippy. 

Se destaca:

- Autenticación con Tokens (Spring security y spring oauth)
- Roles
- Spring Data MongoDB
- Endpoints que satisfacen la logica del negocio.

Como base de datos se eligió monogoDB, dada su rapidez, pero con las suficientes reglas de validación en las colecciones para intentar garantizar la consistrencia de los datos.
pd: Se usó el ingles para evitar bugs por caracteres especiales y sacar provecho del nivel de los integrantes del equipo en el idioma.

## Documentos

Se trabaja en base a las siguientes entidades que se representan una colección en base de datos

- User
- Billing information
- Employee
- Vehicle
- Station
- Trip
- Credential
- Refresh token

Cada uno de ellos cuenta con su respectivo repository (extiende MongoRepository), service (se programa toda la logica) y rest (endpoints).

## Endpoints

A continuación la documentación de los principales endpoints:

### Trip

#### ruta principal: /api/trip

##### get
- /getTrip/{tripId}
  <br><br>
  Requiere token de acceso.
  <br>
  Descripción: Permite obtener la información de un viaje.

- /getAllUserTrips/{userId}
  <br><br>
  Requiere token de acceso.
  <br>
  Descripción: Permite obtener todos los viajes de un usuario.

##### post

- /startNewTrip
  <br><br>
  Requiere token de acceso
  <br>
  Descripción: Permite iniciar un nuevo viaje. El viaje se inicia al usuario del token de acceso.
  <br>
  Requiere en el cuerpo: ObjectId vehicleId, ObjectId startStationId, ObjectId endStationId, BigDecimal distance, int duration.
  <br>
  Condiciones: El usuario no puede tener un viaje activo ni reservado, el vehiculo debe estar disponible y las estaciones deben existir.
  
- /reserveTrip
  <br><br>
  Requiere token de acceso
  <br>
  Descripción: Permite reservar un viaje. El viaje se reserva al usuario del token de acceso.
  <br>
  Requiere en el cuerpo: ObjectId vehicleId, ObjectId startStationId, ObjectId endStationId, BigDecimal distance, int duration.
  <br>
  Condiciones: El usuario no puede tener un viaje activo ni reservado, el vehiculo debe estar disponible y las estaciones deben existir.
  
  
##### put
- /startReserveTrip/{tripDuration}
  <br><br>
  Requiere token de acceso
  <br>
  Descripción: Permite iniciar un viaje que ya se encuentra en estado reservado por el usuario del token de acceso.
  <br>
  Requiere la duración del viaje como path variable.
  <br>
  Condiciones: El usuario debe tener un viaje reservado.

-/cancelReserveTrip
  <br><br>
  Requiere token de acceso
  <br>
  Descripción: Permite cancelar el viaje reservado previamente por el usuario del token de acceso.
  <br>
  Condiciones: El usuario debe tener un viaje reservado.

-/endActualTrip
  <br><br>
  Requiere token de acceso
  <br>
  Descripción: Permite terminar el viaje del usuario del token de acceso
  <br>
  Condiciones: El usuario debe tener un viaje activo.
  <br>
  Opcional: Se le puede pasar en el cuerpo Integer userRating y String userComment.


### User

#### ruta principal: /api/user

##### put
- /update/{id}
  <br><br>
  Requiere token de acceso
  <br>
  Descripción: Permite actualizar los datos personales de un usuario (no se incluye las credenciales de inicio de sesión).
  <br>
  Requiere en el cuerpo: String email, String phone, Address address, String occupation.
  
##### get
- /{id}
  <br><br>
  Requiere token de acceso.
  <br>
  Descripción: Permite obtener la información del usuario correspondiente al id del path variable.
  Condiciones: El id del usuario del token de acceso debe coincidir con el id del path varible.
  
##### delete
- /delete/{id}
  <br><br>
  Requiere token de acceso.
  <br>
  Descripción: Permite borrar de forma permanente un usuario.
  Condiciones: El id del usuario del token de acceso debe coincidir con el id del path varible.


## ¿Qué es "Zippy"?

### Misión

En Zippy, nuestra misión es revolucionar el transporte en Bucaramanga al ofrecer una solución de movilidad sostenible, eficiente y conveniente para sus habitantes. Queremos mejorar la calidad de vida de la comunidad al proporcionar un servicio de alquiler de vehículos eléctricos y ecoamigables que sea confiable, accesible y amigable con el medio ambiente

### Propuesta Única de Valor (PUV)

Zippy se distinguirá por ser la primera startup dedicada al alquiler de vehículos eléctricos en Bucaramanga. Nuestra plataforma ofrecerá una experiencia integral a los usuarios, permitiéndoles gestionar sus viajes diarios de manera práctica y segura. A través de nuestra aplicación, los usuarios podrán: 
- Encontrar estaciones cercanas
- Reservar vehículos
- Conocer la disponibilidad en tiempo real
- visualizar rutas seguras
- Realizar pagos de forma sencilla y conveniente.

### Oportunidad y Mercado

Bucaramanga presenta una gran oportunidad para el alquiler de vehículos eléctricos debido a sus cortas distancias y red de ciclo vías, que son ideales para movilizarse de manera sostenible. Además, el ineficiente transporte público de la ciudad crea una demanda latente por una alternativa más confiable y eficiente. Se estima que un servicio de alquiler de vehículos eléctricos puede tener un impacto significativo en la calidad de vida de los habitantes y generar un cambio positivo en la movilidad urbana.

### Equipo

El equipo fundador de Zippy está conformado por 3 de los mejores estudiantes de la Universidad Industrial de Santander, impactados por el campo de la tecnología y movilidad sostenible. Nuestra pasión por la innovación y el compromiso con el desarrollo sostenible nos impulsa a liderar este proyecto con éxito.

### Modelo de negocio

Zippy operará bajo un modelo de negocio basado en tarifas por uso, ofreciendo opciones flexibles para adaptarse a las necesidades de nuestros usuarios. Además, implementaremos membresías y programas de fidelización para incentivar el uso recurrente de nuestros servicios. Nuestro objetivo es lograr un equilibrio entre la rentabilidad y el impacto social y ambiental positivo.

¡Únete a nosotros y se parte del futuro de la movilidad sostenible!


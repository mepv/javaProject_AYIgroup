# Mario
Repositorio de Mario Palacios.

# SpringDataBaseApp

- Aplicación para ver una lista de clientes con una lista de productos.

- La aplicación puede hacer las operaciones CRUD - Create, Read, Update and Delete.

- La aplicación esta implementando la dependencia del proyecto Lombok.

- La data está guardada en memoria usando la base de datos H2 Database.

- La misma se encuentra en desarrollo. La implementación de la relación ManyToMany junto con JoinTable no relaciona correctamente las entidades. Si bien se crea la tabla join 'customer_product' con sus respectivas FOREIGN KEY, las PRIMARY KEY de cada entidad no están siendo guardadas en la tabla. 

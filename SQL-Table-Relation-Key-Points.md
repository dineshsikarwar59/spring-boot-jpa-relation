# SQL TABLE RELATIONSHIP KEY POINTS 

### One To One Relationship 

## Example

### Person Table

| id | name |
|----|------|
| 1 | John |
| 2 | Alice |

### Passport Table

| id | passport_number | person_id |
|----|-----------------|-----------|
| 101 | P123456 | 1 |
| 102 | P987654 | 2 |

Here:

- One **Person** has one **Passport**.
- One **Passport** belongs to one **Person**.


- The key point is Person can exist without passport 
- but passport can't exist without person 
- means person_id should be inside passport table.
- foreign id always comes inside child table 

- -----
-------

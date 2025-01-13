CREATE TABLE user (
    user_id bigint AUTO_INCREMENT,
    user_name varchar(100),
    primary key (user_id)
);

CREATE TABLE role (
    role_id bigint AUTO_INCREMENT,
    role varchar(50),
    primary key (role_id)
);
CREATE TABLE user_role (
    user_id bigint,
    role_id bigint,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);


CREATE TABLE address (
    address_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(255),
    user_id BIGINT,               -- Foreign key referencing user_id in the 'user' table
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE post (
    post_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each post
    content TEXT NOT NULL,             -- Content of the post
    user_id BIGINT NOT NULL,              -- Foreign key referencing the User table
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp for when the post is created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Timestamp for last update
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE -- Define foreign key relationship
);

CREATE TABLE aadhaar (
    aadhaar_id bigint AUTO_INCREMENT,
    aadhaar_number varchar(50),
    user_id bigint not null,
    primary key (aadhaar_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id)
);
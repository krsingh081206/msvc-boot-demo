create database demodb;

use demodb;

INSERT INTO `admin_users_t`(`id`,`active_status_flag`,`emailid`,`firstname`,`lastname`,`password`,`userid`) VALUES (1,1,'admin@gmail.com','admin','User','$2a$10$5pd5axV6sqQ5oi5BXxjKou2gXCarp0ewLzyGsHx3mwz3VpWNDXItS','admin');
INSERT INTO `admin_users_t`(`id`,`active_status_flag`,`emailid`,`firstname`,`lastname`,`password`,`userid`) VALUES (2,1,'dashboarduser@gmail.com','guest','User','$2a$10$5pd5axV6sqQ5oi5BXxjKou2gXCarp0ewLzyGsHx3mwz3VpWNDXItS','guest_user');





/*
 * To create admin permissions
 */


INSERT INTO `admin_permissions_t` (`id`, `descr`, `name`) VALUES (1, 'view configuration', 'VIEW_CONFIGURATION');

INSERT INTO `admin_permissions_t` (`id`, `descr`, `name`) VALUES (2, 'edit configuration', 'EDIT_CONFIGURATION');



/*
 * To create admin roles
 */
INSERT INTO `admin_roles_t` (`id`, `descr`, `name`) VALUES (1, 'Administrator', 'ADM');
INSERT INTO `admin_roles_t` (`id`, `descr`, `name`) VALUES (2, 'Guest_User', 'GUEST');


/*
 * To map roles and permissions 
 */
INSERT INTO `roles_permissions` (`role_id`, `permission_id`) VALUES (1, 1);
INSERT INTO `roles_permissions` (`role_id`, `permission_id`) VALUES (1, 2);
INSERT INTO `roles_permissions` (`role_id`, `permission_id`) VALUES (2, 1);
/*
 * To map users and roles 
 */
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);
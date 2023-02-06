INSERT INTO humandev.profile (name) VALUES
    ('ROLE_STUDENT'),
    ('ROLE_ADMIN');

INSERT INTO humandev.user (email, password) VALUES
    ('fabiano@alura', '$2a$10$esVY9A3zjete7yeNyw0fNeq0iuwd9l5B2kVLNL9.6VHXMH9e3qqb2'),
    ('admin@alura.com', '$2a$10$esVY9A3zjete7yeNyw0fNeq0iuwd9l5B2kVLNL9.6VHXMH9e3qqb2');

INSERT INTO humandev.profile_users (profiles_id, users_id) VALUES
    (1, 1),
    (2, 2);

INSERT INTO humandev.category (id, active, category_description, code, hexa_color, icon, name, ordination, study_guide) VALUES
    (1, true, 'Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.', 'programacao', '#00c86f', 'https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png', 'Programação', 1, 'study guide'),
    (2, true, 'Aprenda Git. Entenda a entrega contínua. Estude Linux. Gerencie servidores na nuvem. Explore o mundo de Internet das coisas e da robótica.', 'devops', '#f16165', 'https://www.alura.com.br/assets/api/formacoes/categorias/512/devops-transparent.png', 'DevOps', 2, 'study guide'),
    (3, true, 'business', 'business', '#ff8c2a', 'https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png', 'Business', 5, ''),
    (4, true, 'science', 'science', '#FFF', 'https://www.alura.com.br/assets/api/formacoes/categorias/128/data-science.png', 'Science', 6, 'muitos estudos'),
    (5, true, 'html e css', 'front', '#FFA', 'https://www.alura.com.br/assets/api/formacoes/categorias/128/front-end.png', 'FrontEnd', 11, 'estudos');

INSERT INTO humandev.subcategory (id, active, code, name, ordination, study_guide, subcategory_description, category_id) VALUES
    (1, true, 'java', 'Java', 1, 'guia', null, 1),
    (2, true, 'java-e-persistencia', 'Java e Persistência', 3, 'guia', null, 1),
    (3, true, 'php', 'PHP', 2, 'guia', null, 1),
    (4, true, 'cobol', 'COBOL', 4, 'muitos estudos', null, 2),
    (5, true, 'builds', 'Builds e Controle de versão', 5, 'estudos', null, 2),
    (6, true, 'soft', 'SoftSkills', 6, 'aleatório', null, 2),
    (7, true, 'js', 'js', 6, 'js-begin', null, 3),
    (8, true, 'c', 'c', 2, 'c-starting-up', null, 3);

INSERT INTO humandev.course (id, active, code, course_description, course_time_hours, developed_skills, instructor, name, target_audience, subcategory_id) VALUES
    (4, true, 'git-e-github-para', 'muita informação', 6, null, 'tio Bill', 'Git e Github ', 'developers', 1),
    (5, true, 'java-jpa-consultas-avancadas-performance-modelos-complexos', 'muita informação', 16, null, 'tio Bill', 'Java e JPA: Consultas avançadas performance e modelos complexos', 'developers', 1),
    (6, true, 'java-introducao-orientacao-objetos', 'muita informação', 8, null, 'tio Bill', 'Java OO: Introdução à Orientação a Objetos', 'Desenvolvedores que estão começando com Java e querem aprender mais sobre OO.', 4),
    (7, true, 'java-primeiros-passos', 'muita informação', 8, null, 'tio Bill', 'Java JRE e JDK: Escreva o seu primeiro código com Eclipse', 'Desenvolvedores que estão começando com Java e querem aprender mais sobre OO.', 4),
    (8, true, 'angular', '- Conheça todos os comando da CLI do Angular. <br> - Saiba como funcionam as Workspaces no angular.json. <br> - Saiba como o Schematics pode aumentar sua produtividade <br> - Garanta consistência e otimizações para produção com o Builder.', 15, null, 'tio Bill', 'Angular CLI', 'developers', 4),
    (9, true, 'ux', 'consistência e otimizações para produção com o Builder.', 15, null, 'Silveirinha', 'Projecting games', 'developers', 7),
    (10, true, 'logica', 'performance-modelos-complexos', 19, null, 'Maria', 'SoftSkills', 'Pessoas', 7),
    (11, true, 'programacao', 'consultas-avancadas-performance-modelos', 4, null, 'Maria', 'Entenda a entrega contínua', 'developers', 7),
    (12, true, 'test', 'Entenda a entrega contínua', 1, null, 'tio Bill', 'Entenda a entrega contínua', '1', 7);
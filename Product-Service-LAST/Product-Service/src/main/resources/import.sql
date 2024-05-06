INSERT INTO products(product_Name,product_Description,product_Price,product_Stock,product_URL)values('Aretes hilo negro','Aretes con hilos y cortezas de capullos de seda 100% natural',35000,1,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240223_121702-8d263f7f-fa97-445f-ad96-d57d02ca0e98.jpg');
INSERT INTO products(product_Name,product_Description,product_Price,product_Stock,product_URL)values('Chal hueso','Chal tejido a mano de color hueso con lana 100% natural',220000,1,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-12-image-1-c38c8c03-8541-406c-8188-5bc4d32d2868.jpg');
INSERT INTO products(product_Name,product_Description,product_Price,product_Stock,product_URL)values('Ruana dorada','Ruana tejida a mano de color dorado con fibras de alta calidad',330000,1,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-21-image-2-c21c5957-5178-44e2-a069-3c6c67315876.jpg');
INSERT INTO products(product_Name,product_Description,product_Price,product_Stock,product_URL)values('Poncho gris con dorado ABA9','Este poncho es una verdadera obra de arte. Hecho a mano por artesanos expertos, combina la elegancia de la seda con un diseño único y moderno. El color gris con toques de dorado crea un efecto sutil y sofisticado que se adapta a cualquier ocasión.',330000,1,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_016_20221206_194939_compressed-853599e3-207c-4eaa-a06a-c65654d13414.jpg');
INSERT INTO products(product_Name,product_Description,product_Price,product_Stock,product_URL)values('Bufanda turquesa','Bufanda color turquesa tejida a mano de excelente calidad',140000,1,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-10-image-2-053b771e-b32f-4ba1-8952-db0a5f10182d.jpg');
INSERT INTO products(product_Name,product_Description,product_Price,product_Stock,product_URL)values('Pañoleta dorado y naranja','Pañoleta fina, excelente para una ocasion elegante y tejida a mano',90000,1,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-11-image-1-38430385-f8fa-49b5-971e-1bec2bfdec33.jpg');


INSERT INTO categories(category_Name)values('Aretes');
INSERT INTO categories(category_Name)values('Chales');
INSERT INTO categories(category_Name)values('Ruanas');
INSERT INTO categories(category_Name)values('Ponchos');
INSERT INTO categories(category_Name)values('Bufandas');
INSERT INTO categories(category_Name)values('Pañoletass');

INSERT INTO Product_Category(product_Id,category_Id)values(1,1);
INSERT INTO Product_Category(product_Id,category_Id)values(2,2);
INSERT INTO Product_Category(product_Id,category_Id)values(3,3);
INSERT INTO Product_Category(product_Id,category_Id)values(4,4);
INSERT INTO Product_Category(product_Id,category_Id)values(5,5);
INSERT INTO Product_Category(product_Id,category_Id)values(6,6);
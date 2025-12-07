# 🏢 Property Management System

A modern web-based Property Management System built with **Spring Boot**, **Thymeleaf**, and **Bootstrap**. Manage landlords, properties, tenants, bills, and payments through an intuitive web interface.

## 📋 Features

- ✅ **Dashboard** - Overview with statistics and recent data
- 🏠 **Property Management** - Add and track properties
- 👥 **Tenant Management** - Manage tenants and room assignments
- 💵 **Bill & Payment Tracking** - Create bills and record payments
- 👤 **Landlord Management** - Manage property owners
- 📱 **Responsive Design** - Works on desktop and mobile

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.2.0, Spring Data JPA
- **Frontend**: Thymeleaf, Bootstrap 5.3.0
- **Database**: H2 (in-memory)
- **Build Tool**: Maven
- **Deployment**: Heroku

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git

### Local Development

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/property-management-web.git
cd property-management-web
```

2. **Build the project**
```bash
mvn clean package
```

3. **Run the application**
```bash
java -jar target/property-management-web-1.0.0.jar
```

4. **Access the application**
- Open browser: `http://localhost:8080`
- H2 Console (optional): `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:propertydb`
  - Username: `sa`
  - Password: (leave empty)

## 📦 Deployment to Heroku

### Option 1: Heroku CLI

1. **Login to Heroku**
```bash
heroku login
```

2. **Create Heroku app**
```bash
heroku create your-app-name
```

3. **Deploy**
```bash
git push heroku main
```

4. **Open your app**
```bash
heroku open
```

### Option 2: GitHub + Heroku (Recommended)

1. **Push to GitHub**
```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/yourusername/property-management-web.git
git push -u origin main
```

2. **Connect to Heroku**
   - Go to [Heroku Dashboard](https://dashboard.heroku.com/)
   - Click "New" → "Create new app"
   - Choose app name and region
   - In "Deployment method", select "GitHub"
   - Connect your GitHub repository
   - Enable "Automatic deploys" from main branch
   - Click "Deploy Branch"

3. **Your app is live!** 🎉
   - Access at: `https://your-app-name.herokuapp.com`

## 📖 Usage Guide

### 1. Add a Landlord
- Navigate to "Landlords" page
- Enter landlord name and contact info
- Click "Add"

### 2. Add Properties
- Go to "Properties" page
- Enter property address and type
- Select landlord from dropdown
- Click "Add"

### 3. Add Tenants
- Go to "Tenants" page
- Enter tenant details
- Select property from dropdown
- Assign room ID
- Click "Add"

### 4. Create Bills
- Navigate to "Bills & Payments"
- Select tenant, enter bill type and amount
- Click "Create Bill"

### 5. Record Payments
- In "Bills & Payments" page
- Select tenant, enter payment amount and type
- Click "Record Payment"
- Optionally mark bills as paid from the table below

## 🎓 For Viva/Presentation

This project demonstrates:
- **MVC Architecture** - Model-View-Controller pattern
- **ORM** - JPA entity relationships (OneToMany, ManyToOne)
- **Dependency Injection** - Spring's @Autowired
- **RESTful Design** - HTTP methods (GET, POST)
- **Template Engine** - Thymeleaf server-side rendering
- **Responsive UI** - Bootstrap framework
- **Database** - H2 in-memory database
- **Cloud Deployment** - Heroku PaaS

## 📁 Project Structure

```
property-management-web/
├── src/main/
│   ├── java/com/propertymanagement/
│   │   ├── PropertyManagementApplication.java
│   │   ├── model/          # JPA entities
│   │   ├── repository/     # Data access layer
│   │   └── controller/     # Web controllers
│   └── resources/
│       ├── templates/      # Thymeleaf HTML
│       ├── static/css/     # CSS files
│       └── application.properties
├── pom.xml                 # Maven dependencies
├── Procfile                # Heroku deployment
└── system.properties       # Java version
```

## 🔧 Configuration

Edit `src/main/resources/application.properties` to customize:
- Server port
- Database settings
- JPA configuration

## 📝 Notes

- **Database**: H2 in-memory DB resets on restart (perfect for demo)
- **For Production**: Replace H2 with PostgreSQL or MySQL
- **Security**: Add Spring Security for authentication (future enhancement)

## 👨‍💻 Author

Created as an OOP project demonstration

## 📄 License

MIT License - Free to use for educational purposes

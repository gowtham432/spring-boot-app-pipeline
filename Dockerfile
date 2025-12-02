# Multi-stage build for Maven application
        FROM eclipse-temurin:21-jre-jammy
        
        WORKDIR /app
        
        # Create non-root user
        RUN groupadd -r appuser && useradd -r -g appuser appuser
        
        # Copy the JAR file
        COPY target/*.jar app.jar
        
        # Change ownership
        RUN chown -R appuser:appuser /app
        
        # Switch to non-root user
        USER appuser
        
        # Expose port
        EXPOSE 8080
        
        # Run the application
        ENTRYPOINT ["java", "-jar", "app.jar"]
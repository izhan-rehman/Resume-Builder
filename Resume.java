import java.util.Scanner;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;

class Resume {
    // Personal Information
    String name, email, phone, address, linkedin, github;
    String objective;

    // Education
    List<Education> educationList = new ArrayList<>();

    // Skills
    List<String> technicalSkills = new ArrayList<>();
    List<String> softSkills = new ArrayList<>();
    List<String> languages = new ArrayList<>();

    // Work Experience
    List<Experience> experienceList = new ArrayList<>();

    // Projects
    List<Project> projectList = new ArrayList<>();

    // Certifications
    List<String> certifications = new ArrayList<>();

    void getDetails() {
        Scanner sc = new Scanner(System.in);

        // Personal Information
        System.out.println("\n===== PERSONAL INFORMATION =====");
        System.out.print("Enter your full name: ");
        name = sc.nextLine();

        System.out.print("Enter your email: ");
        email = sc.nextLine();

        System.out.print("Enter your phone number: ");
        phone = sc.nextLine();

        System.out.print("Enter your address: ");
        address = sc.nextLine();

        System.out.print("Enter your LinkedIn URL (leave blank if none): ");
        linkedin = sc.nextLine();

        System.out.print("Enter your GitHub URL (leave blank if none): ");
        github = sc.nextLine();

        System.out.print("Enter your career objective: ");
        objective = sc.nextLine();

        // Education
        System.out.println("\n===== EDUCATION =====");
        String more = "y";
        while (more.equalsIgnoreCase("y")) {
            Education edu = new Education();

            System.out.print("Enter degree/qualification: ");
            edu.degree = sc.nextLine();

            System.out.print("Enter institution name: ");
            edu.institution = sc.nextLine();

            System.out.print("Enter location: ");
            edu.location = sc.nextLine();

            System.out.print("Enter start date (MM/YYYY): ");
            edu.startDate = sc.nextLine();

            System.out.print("Enter end date (MM/YYYY or 'Present'): ");
            edu.endDate = sc.nextLine();

            System.out.print("Enter GPA (if applicable): ");
            edu.gpa = sc.nextLine();

            System.out.print("Enter relevant coursework (comma separated): ");
            edu.coursework = sc.nextLine();

            educationList.add(edu);

            System.out.print("Add another education entry? (y/n): ");
            more = sc.nextLine();
        }

        // Technical Skills
        System.out.println("\n===== TECHNICAL SKILLS =====");
        System.out.println("Enter technical skills (programming languages, tools, frameworks, etc.)");
        System.out.println("Enter one skill at a time. Type 'done' when finished.");

        String skill = "";
        while (true) {
            System.out.print("Skill: ");
            skill = sc.nextLine();
            if (skill.equalsIgnoreCase("done")) break;
            technicalSkills.add(skill);
        }

        // Soft Skills
        System.out.println("\n===== SOFT SKILLS =====");
        System.out.println("Enter soft skills (communication, leadership, etc.)");
        System.out.println("Enter one skill at a time. Type 'done' when finished.");

        while (true) {
            System.out.print("Soft Skill: ");
            skill = sc.nextLine();
            if (skill.equalsIgnoreCase("done")) break;
            softSkills.add(skill);
        }

        // Languages
        System.out.println("\n===== LANGUAGES =====");
        System.out.println("Enter languages you know (with proficiency level)");
        System.out.println("Example: English (Native), Spanish (Intermediate)");
        System.out.println("Enter one language at a time. Type 'done' when finished.");

        while (true) {
            System.out.print("Language: ");
            skill = sc.nextLine();
            if (skill.equalsIgnoreCase("done")) break;
            languages.add(skill);
        }

        // Work Experience
        System.out.println("\n===== WORK EXPERIENCE =====");
        more = "y";
        while (more.equalsIgnoreCase("y")) {
            Experience exp = new Experience();

            System.out.print("Enter job title: ");
            exp.jobTitle = sc.nextLine();

            System.out.print("Enter company name: ");
            exp.company = sc.nextLine();

            System.out.print("Enter location: ");
            exp.location = sc.nextLine();

            System.out.print("Enter start date (MM/YYYY): ");
            exp.startDate = sc.nextLine();

            System.out.print("Enter end date (MM/YYYY or 'Present'): ");
            exp.endDate = sc.nextLine();

            System.out.println("Enter responsibilities/achievements (up to 5).");
            System.out.println("Enter one at a time. Type 'done' when finished.");

            for (int i = 0; i < 5; i++) {
                System.out.print("Responsibility/Achievement " + (i + 1) + ": ");
                String resp = sc.nextLine();
                if (resp.equalsIgnoreCase("done")) break;
                exp.responsibilities.add(resp);
            }

            experienceList.add(exp);

            System.out.print("Add another work experience entry? (y/n): ");
            more = sc.nextLine();
        }

        // Projects
        System.out.println("\n===== PROJECTS =====");
        more = "y";
        while (more.equalsIgnoreCase("y")) {
            Project proj = new Project();

            System.out.print("Enter project name: ");
            proj.name = sc.nextLine();

            System.out.print("Enter technologies used: ");
            proj.technologies = sc.nextLine();

            System.out.print("Enter project URL (if applicable): ");
            proj.url = sc.nextLine();

            System.out.print("Enter date (MM/YYYY): ");
            proj.date = sc.nextLine();

            System.out.println("Enter description/key features (up to 3).");
            System.out.println("Enter one at a time. Type 'done' when finished.");

            for (int i = 0; i < 3; i++) {
                System.out.print("Description " + (i + 1) + ": ");
                String desc = sc.nextLine();
                if (desc.equalsIgnoreCase("done")) break;
                proj.description.add(desc);
            }

            projectList.add(proj);

            System.out.print("Add another project? (y/n): ");
            more = sc.nextLine();
        }

        // Certifications
        System.out.println("\n===== CERTIFICATIONS =====");
        System.out.println("Enter certifications or awards");
        System.out.println("Enter one at a time. Type 'done' when finished.");

        while (true) {
            System.out.print("Certification: ");
            String cert = sc.nextLine();
            if (cert.equalsIgnoreCase("done")) break;
            certifications.add(cert);
        }

        sc.close();
    }
    //Ashish
    void displayResume() {
        System.out.println("\n==================== RESUME ====================");
        // Personal Information
        System.out.println("\n" + name.toUpperCase());
        System.out.println(email + " | " + phone);
        System.out.println(address);
        if (!linkedin.isEmpty()) System.out.println("LinkedIn: " + linkedin);
        if (!github.isEmpty()) System.out.println("GitHub: " + github);

        // Objective
        System.out.println("\n----- CAREER OBJECTIVE -----");
        System.out.println(objective);

        // Education
        System.out.println("\n----- EDUCATION -----");
        for (Education edu : educationList) {
            System.out.println(edu.degree);
            System.out.println(edu.institution + ", " + edu.location);
            System.out.println(edu.startDate + " - " + edu.endDate);
            if (!edu.gpa.isEmpty()) System.out.println("GPA: " + edu.gpa);
            if (!edu.coursework.isEmpty()) System.out.println("Relevant Coursework: " + edu.coursework);
            System.out.println();
        }

        // Skills
        System.out.println("----- SKILLS -----");
        System.out.println("Technical Skills: " + String.join(", ", technicalSkills));
        System.out.println("Soft Skills: " + String.join(", ", softSkills));
        System.out.println("Languages: " + String.join(", ", languages));

        // Work Experience
        System.out.println("\n----- WORK EXPERIENCE -----");
        for (Experience exp : experienceList) {
            System.out.println(exp.jobTitle);
            System.out.println(exp.company + ", " + exp.location);
            System.out.println(exp.startDate + " - " + exp.endDate);
            System.out.println("Responsibilities/Achievements:");
            for (String resp : exp.responsibilities) {
                System.out.println("• " + resp);
            }
            System.out.println();
        }

        // Projects
        System.out.println("----- PROJECTS -----");
        for (Project proj : projectList) {
            System.out.println(proj.name + " (" + proj.date + ")");
            System.out.println("Technologies: " + proj.technologies);
            if (!proj.url.isEmpty()) System.out.println("URL: " + proj.url);
            for (String desc : proj.description) {
                System.out.println("• " + desc);
            }
            System.out.println();
        }

        // Certifications
        if (!certifications.isEmpty()) {
            System.out.println("----- CERTIFICATIONS & AWARDS -----");
            for (String cert : certifications) {
                System.out.println("• " + cert);
            }
        }

        System.out.println("\n==============================================");
    }

    void generatePDF() {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Professional_Resume.pdf"));
            document.open();

            // Set up fonts
            Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
            Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font subHeadingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, BaseColor.DARK_GRAY);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
            Font italicFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, BaseColor.BLACK);

            // Add current date
            Paragraph dateP = new Paragraph(new SimpleDateFormat("MMMM dd, yyyy").format(new Date()),
                    FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.GRAY));
            dateP.setAlignment(Element.ALIGN_RIGHT);
            document.add(dateP);

            // Add personal information
            Paragraph nameP = new Paragraph(name.toUpperCase(), nameFont);
            nameP.setAlignment(Element.ALIGN_CENTER);
            document.add(nameP);

            Paragraph contactP = new Paragraph(email + " | " + phone, normalFont);
            contactP.setAlignment(Element.ALIGN_CENTER);
            document.add(contactP);

            Paragraph addressP = new Paragraph(address, normalFont);
            addressP.setAlignment(Element.ALIGN_CENTER);
            document.add(addressP);

            if (!linkedin.isEmpty() || !github.isEmpty()) {
                String profiles = "";
                if (!linkedin.isEmpty()) profiles += "LinkedIn: " + linkedin;
                if (!linkedin.isEmpty() && !github.isEmpty()) profiles += " | ";
                if (!github.isEmpty()) profiles += "GitHub: " + github;

                Paragraph profileP = new Paragraph(profiles, normalFont);
                profileP.setAlignment(Element.ALIGN_CENTER);
                document.add(profileP);
            }

            document.add(Chunk.NEWLINE);

            // Add section line
            PdfContentByte cb = writer.getDirectContent();
            cb.setColorStroke(new BaseColor(70, 130, 180));
            cb.setLineWidth(1f);
            cb.moveTo(36, document.getPageSize().getHeight() - 110);
            cb.lineTo(document.getPageSize().getWidth() - 36, document.getPageSize().getHeight() - 110);
            cb.stroke();

            // Add objective
            document.add(new Paragraph("CAREER OBJECTIVE", headingFont));
            document.add(new Paragraph(objective, normalFont));
            document.add(Chunk.NEWLINE);

            // Add education
            document.add(new Paragraph("EDUCATION", headingFont));
            for (Education edu : educationList) {
                Paragraph degreeP = new Paragraph(edu.degree, subHeadingFont);
                document.add(degreeP);

                Paragraph instP = new Paragraph(edu.institution + ", " + edu.location, normalFont);
                document.add(instP);

                Paragraph dateP2 = new Paragraph(edu.startDate + " - " + edu.endDate, italicFont);
                document.add(dateP2);

                if (!edu.gpa.isEmpty()) {
                    Paragraph gpaP = new Paragraph("GPA: " + edu.gpa, normalFont);
                    document.add(gpaP);
                }

                if (!edu.coursework.isEmpty()) {
                    Paragraph courseP = new Paragraph("Relevant Coursework: " + edu.coursework, normalFont);
                    document.add(courseP);
                }

                document.add(Chunk.NEWLINE);
            }

            // Add skills
            document.add(new Paragraph("SKILLS", headingFont));

            // Technical skills
            Paragraph techP = new Paragraph();
            Chunk techHeadingChunk = new Chunk("Technical Skills: ", subHeadingFont);
            techP.add(techHeadingChunk);
            techP.add(new Chunk(String.join(", ", technicalSkills), normalFont));
            document.add(techP);

            // Soft skills
            Paragraph softP = new Paragraph();
            Chunk softHeadingChunk = new Chunk("Soft Skills: ", subHeadingFont);
            softP.add(softHeadingChunk);
            softP.add(new Chunk(String.join(", ", softSkills), normalFont));
            document.add(softP);

            // Languages
            Paragraph langP = new Paragraph();
            Chunk langHeadingChunk = new Chunk("Languages: ", subHeadingFont);
            langP.add(langHeadingChunk);
            langP.add(new Chunk(String.join(", ", languages), normalFont));
            document.add(langP);
            document.add(Chunk.NEWLINE);

            // Add work experience
            document.add(new Paragraph("WORK EXPERIENCE", headingFont));
            for (Experience exp : experienceList) {
                Paragraph jobTitleP = new Paragraph(exp.jobTitle, subHeadingFont);
                document.add(jobTitleP);

                Paragraph companyP = new Paragraph(exp.company + ", " + exp.location, normalFont);
                document.add(companyP);

                Paragraph dateP3 = new Paragraph(exp.startDate + " - " + exp.endDate, italicFont);
                document.add(dateP3);

                for (String resp : exp.responsibilities) {
                    Paragraph respP = new Paragraph("• " + resp, normalFont);
                    document.add(respP);
                }
                document.add(Chunk.NEWLINE);
            }

            // Add projects
            document.add(new Paragraph("PROJECTS", headingFont));
            for (Project proj : projectList) {
                Paragraph projectNameP = new Paragraph(proj.name + " (" + proj.date + ")", subHeadingFont);
                document.add(projectNameP);

                Paragraph techP2 = new Paragraph("Technologies: " + proj.technologies, normalFont);
                document.add(techP2);

                if (!proj.url.isEmpty()) {
                    Paragraph urlP = new Paragraph("URL: " + proj.url, normalFont);
                    document.add(urlP);
                }

                for (String desc : proj.description) {
                    Paragraph descP = new Paragraph("• " + desc, normalFont);
                    document.add(descP);
                }
                document.add(Chunk.NEWLINE);
            }

            // Add certifications
            if (!certifications.isEmpty()) {
                document.add(new Paragraph("CERTIFICATIONS & AWARDS", headingFont));
                for (String cert : certifications) {
                    Paragraph certP = new Paragraph("• " + cert, normalFont);
                    document.add(certP);
                }
                document.add(Chunk.NEWLINE);
            }

            // Close the document
            document.close();
            System.out.println("Resume PDF generated successfully: Professional_Resume.pdf");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error generating PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Resume resume = new Resume();
        resume.getDetails();
        resume.displayResume();
        resume.generatePDF();
    }
}

// Education class
class Education {
    String degree, institution, location, startDate, endDate, gpa, coursework;
}

// Experience class
class Experience {
    String jobTitle, company, location, startDate, endDate;
    List<String> responsibilities = new ArrayList<>();
}

// Project class
class Project {
    String name, technologies, url, date;
    List<String> description = new ArrayList<>();
}
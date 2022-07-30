
package com.pil.grim.Controller;
import com.pil.grim.Model.Tarea;
import com.pil.grim.Service.TareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="https://aparanguren-c84d6.web.app")
@RequestMapping("/api")

public class TareaController {
     @Autowired
    private TareaService tareaService;
      
    //listar
    @GetMapping("/tareas")
    public List<Tarea> listar()
    {
        return tareaService.findAll();
    }
    
    //guardar
    @PostMapping("/tareas")
    public  Tarea guardar(@RequestBody Tarea tarea)
    {
        return tareaService.save(tarea);
    }
    
    //get una tarea
    @GetMapping("/tareas/{id}")
    public Tarea getUnaTarea(@PathVariable Integer id)
    {
        return tareaService.findById(id);
    }
    
    //Modeficar
    @PutMapping("/tareas/{id}")
    public Tarea modifecar(@RequestBody Tarea tarea,@PathVariable Integer id)
    {
        Tarea tareaActual= tareaService.findById(id);
        tareaActual.setTipo(tarea.getTipo());
        tareaActual.setActividad(tarea.getActividad());
        tareaActual.setFoto(tarea.getFoto());
        
        return tareaService.save(tareaActual);
    }
    
    @DeleteMapping("/tareas/{id}")
    public void eliminar(@PathVariable Integer id)
    {
        tareaService.delete(id);
    }
}
